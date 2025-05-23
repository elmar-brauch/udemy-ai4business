package de.bsi.udemyai4business.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class MemoryChatService {

    private final ChatClient chatClient;

    public MemoryChatService(ChatModel llm) {
        var chatMemory = MessageWindowChatMemory.builder().maxMessages(3).build();
        var chatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();

        this.chatClient = ChatClient.builder(llm)
                .defaultAdvisors(chatMemoryAdvisor)
                .build();
    }

    public String chat(String question) {
        return chatClient.prompt(question).call().content();
    }

}
