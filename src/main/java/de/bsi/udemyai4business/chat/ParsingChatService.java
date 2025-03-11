package de.bsi.udemyai4business.chat;

import de.bsi.udemyai4business.chat.model.Customer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class ParsingChatService {

    private ChatClient chatClient;

    public ParsingChatService(ChatModel llm) {
        // TODO Create ChatClient.
    }

    public Customer identifyCustomer(String text) {
        // TODO Use ChatClient to parse text in Customer object.
        return null;
    }

}
