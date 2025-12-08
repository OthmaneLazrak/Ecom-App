package org.sid.chatbottlg.telegram;

import jakarta.annotation.PostConstruct;
import org.sid.chatbottlg.agents.AiAgent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component

public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.api.key}")
    private String telegramBotToken;

    private AiAgent aiAgent;

    public TelegramBot(AiAgent aiAgent) {
        this.aiAgent = aiAgent;
    }

    @PostConstruct
    public void registerTelegramBot() throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(!update.hasMessage() || !update.getMessage().hasText()){
            return;
        }
        String userMessage = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        try {
            sendTypingQuestion(chatId);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        String answer = aiAgent.askAgent(userMessage)
                .collectList()
                .block()
                .stream()
                .reduce("", (a, b) -> a + b);
        sendTextMessage(update.getMessage().getChatId(), answer);
    }

    @Override
    public String getBotUsername() {
        return "EcomAiBot";
    }

    @Override
    public String getBotToken() {
        return telegramBotToken;
    }

    private void sendTextMessage(Long chatId, String text){
        SendMessage message = new SendMessage(String.valueOf(chatId), text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendTypingQuestion(Long chatId) throws TelegramApiException{
        SendChatAction chatAction = new SendChatAction();
        chatAction.setChatId(String.valueOf(chatId));
        chatAction.setAction(ActionType.TYPING);
        execute(chatAction);
    }
}
