package de.bsi.udemyai4business.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RagChatService {

    private final ChatClient chatClient;

    public RagChatService(ChatModel llm, EmbeddingModel embeddingModel) {
        VectorStore vectorStore = createAndFillVectorStore(embeddingModel);
        QuestionAnswerAdvisor ragAdvisor = QuestionAnswerAdvisor.builder(vectorStore)
                .searchRequest(SearchRequest.builder().topK(1).build())
                .build();

        this.chatClient = ChatClient.builder(llm)
                .defaultAdvisors(ragAdvisor)
                .build();
    }

    public String chat(String question) {
        return chatClient.prompt(question).call().content();
    }

    private VectorStore createAndFillVectorStore(EmbeddingModel embeddingModel) {
        VectorStore vectorStore = SimpleVectorStore.builder(embeddingModel).build();

        Document doc1 = new Document("Germany has only 1 city with more than 1 million people, it is Darmstadt.");
        Document doc2 = new Document("Germanies capital is Darmstadt since 01.01.2026, before it was Frankfurt.");
        Document doc3 = new Document("Germanies biggest mountain is called 'Big Berg', it has a hight of 9001 meters and is the biggest mountain in the world.");
        Document doc4 = new Document("The capital of France is Strasbourg.");
        vectorStore.accept(List.of(doc1, doc2, doc3, doc4));

        return vectorStore;
    }

}
