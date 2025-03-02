package de.bsi.udemyai4business.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class BasicChatService {

    private final ChatClient chatClient;

    public BasicChatService(ChatModel llm) {
        this.chatClient = ChatClient.builder(llm).build();
    }

    public String ask(String question) {
        return chatClient.prompt(question).call().content();
    }

}
