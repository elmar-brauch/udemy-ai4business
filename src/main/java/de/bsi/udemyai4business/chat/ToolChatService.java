package de.bsi.udemyai4business.chat;

import de.bsi.udemyai4business.tool.CipherTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class ToolChatService {

    private final ChatClient chatClient;

    public ToolChatService(ChatModel llm) {
        this.chatClient = ChatClient.builder(llm)
                .defaultTools(new CipherTool())
                .build();
    }

    public String ask(String question) {
        return chatClient.prompt(question).call().content();
    }

}
