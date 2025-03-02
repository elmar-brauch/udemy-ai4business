package de.bsi.udemyai4business.chat;

import de.bsi.udemyai4business.chat.model.Customer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class ParsingChatService {

    private final ChatClient chatClient;

    public ParsingChatService(ChatModel llm) {
        this.chatClient = ChatClient.builder(llm).build();
    }

    // Adding a system prompt to define that the task is to parse a Customer object from given text
    // and describing the nature of the given text improves this AI service.
    public Customer identifyCustomer(String text) {
        return chatClient.prompt(text).call().entity(Customer.class);
    }

}
