package de.bsi.udemyai4business.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class BasicChatService {

    private ChatClient chatClient;

    public BasicChatService(ChatModel llm) {
        // TODO Create ChatClient.
    }

    public String ask(String question) {
        // TODO Use ChatClient to interact with LLM.
        return null;
    }

}
