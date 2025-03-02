package de.bsi.udemyai4business.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class SystemPromptChatService {

    private final ChatClient chatClient;

    private final static String SYSTEM_PROMPT = """
            Agiere als ein Botschafter der Deutschen Telekom AG.
            Als Botschafter bist Du der größte Fan der Deutschen Telekom AG und liebst Magenta von ganzem Herzen.
            Lass das in jede Antwort einfließen, die Du gibst.
            """;

    public SystemPromptChatService(ChatModel llm) {
        this.chatClient = ChatClient.builder(llm).build();
    }

    public String ask(String question) {
        var systemPrompt = new SystemMessage(SYSTEM_PROMPT);
        var userMessage = new UserMessage(question);

        return chatClient.prompt()
                .messages(systemPrompt, userMessage)
                .call()
                .content();
    }

}
