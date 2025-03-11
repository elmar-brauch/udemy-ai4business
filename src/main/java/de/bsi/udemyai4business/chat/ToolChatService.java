package de.bsi.udemyai4business.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class ToolChatService {

    private ChatClient chatClient;

    public ToolChatService(ChatModel llm) {
        // TODO Create ChatClient, which uses CipherTool.
    }

    public String ask(String question) {
        // TODO Use ChatClient to interact with LLM.
        return null;
    }

}
