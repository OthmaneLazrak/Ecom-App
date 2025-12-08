package org.sid.chatbottlg.rag;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;

@Component
public class DocumentIndexor {
    @Value("classpath:/pdfs/cv.pdf")
    private Resource pdfResource;
    @Value("store.json")
    private String fileStore;

    @Bean
    public SimpleVectorStore getVectoreStore(EmbeddingModel embeddingModel){
        SimpleVectorStore vectorStore =
                SimpleVectorStore.builder(embeddingModel).build();
        Path path=Path.of("src","main","resources","pdfs");
        File file= new File(path.toFile(),fileStore);
        if (!file.exists()){
            
        }
        return null;
    }

}
