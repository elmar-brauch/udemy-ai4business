package de.bsi.udemyai4business.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class SystemPromptChatService {

    private ChatClient chatClient;

    private static final String SYSTEM_PROMPT = """
            TODO: Define system prompt here, so that the answer is in different style than in previous exercise.
            """;

    public SystemPromptChatService(ChatModel llm) {
        // TODO Create ChatClient.
    }

    public String ask(String question) {
        // TODO Use ChatClient with UserMessage and SystemMessage.
        return null;
    }

}
