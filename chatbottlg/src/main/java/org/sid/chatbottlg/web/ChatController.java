package org.sid.chatbottlg.web;

import org.sid.chatbottlg.agents.AiAgent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin("*")
public class  ChatController {
    private AiAgent aiAgent;


    public ChatController(AiAgent aiAgent) {
        this.aiAgent = aiAgent;
    }

    @GetMapping(value="/chat", produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> chat(String query) {
        return aiAgent.askAgent(query);
    }
}
/*@GetMapping("/chat")
    public String chat(String query) {
        return chatClient.prompt()
                .user(query)
                .call().content();
    }*/