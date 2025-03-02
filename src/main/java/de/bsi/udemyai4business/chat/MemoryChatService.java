package de.bsi.udemyai4business.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class MemoryChatService {

    private ChatClient chatClient;

    public MemoryChatService(ChatModel llm) {
        var chatMemory = new InMemoryChatMemory();
        var chatMemoryAdvisor = new MessageChatMemoryAdvisor(chatMemory, "conversation-id", 3);

        this.chatClient = ChatClient.builder(llm)
                .defaultAdvisors(chatMemoryAdvisor)
                .build();
    }

    public String chat(String question) {
        return chatClient.prompt(question).call().content();
    }

}
