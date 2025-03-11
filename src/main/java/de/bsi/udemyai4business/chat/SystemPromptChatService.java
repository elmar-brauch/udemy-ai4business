package de.bsi.udemyai4business.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class SystemPromptChatService {

    private ChatClient chatClient;

    private final static String SYSTEM_PROMPT = """
            TODO: Define system prompt here.
            """;

    public SystemPromptChatService(ChatModel llm) {
        // TODO Create ChatClient.
    }

    public String ask(String question) {
        // TODO Use ChatClient with UserMessage and SystemMessage.
        return null;
    }

}
