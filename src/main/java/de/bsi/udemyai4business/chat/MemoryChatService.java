package de.bsi.udemyai4business.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class MemoryChatService {

    private final ChatClient chatClient = null;

    public MemoryChatService(ChatModel llm) {
        // TODO Create ChatClient with InMemoryChatMemory and MessageChatMemoryAdvisor.
    }

    public String chat(String question) {
        // TODO Use ChatClient to interact with LLM.
        return null;
    }

}
