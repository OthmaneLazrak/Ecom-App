/*package org.sid.chatbottlg.tools;

import org.springframework.ai.document.Document;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AiTool {

    SimpleVectorStore vectorStore;

    public AiTool(SimpleVectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }
    @Tool(description = "Chercher les informations concernant le CV de Othmane Lazrek")
    public List<String> searchContext(String query){
        List<Document> documents = vectorStore.similaritySearch(SearchRequest.builder()
                .query(query)
                .topK(4)
                .build());
        return documents.stream()
                .map(Document::getText)
                .collect(Collectors.toList());

    }
}*/
