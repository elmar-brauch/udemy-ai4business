package de.bsi.udemyai4business.chat;

import de.bsi.udemyai4business.chat.model.EncryptedText;
import de.bsi.udemyai4business.tool.CipherTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class ToolChatService {

    private final ChatClient chatClient;

    private static final String SYSTEM_PROMPT = """
            Your task is to extract a text or word from the user's message, encrypt it using the provided CipherTool, and return the result as a JSON object.
            Follow these steps strictly:
            1. Identify the word or text the user wants to encrypt.
            2. Use only the CipherTool to encrypt the identified word or text.
            3. Return a valid JSON object with:
            -- text: the original (unencrypted) word or text from the user.
            -- encryptedText: the exact output of the CipherTool, with no changes whatsoever.
            
            Important:
            - Do not modify, rephrase, shorten, format, or post-process the result from the CipherTool.
            - Do not include any explanation or text outside of the JSON object.
            - Do not add quotation marks or escape characters beyond those needed for valid JSON.
            
            Example:
            User message: "Please encrypt the word hello."
            CipherTool returns: jgnnq
            Your response must be:
            {
              "text": "hello",
              "encryptedText": "jgnnq"
            }
            This format must be followed exactly in every case.
            """;

    public ToolChatService(ChatModel llm) {
        // Powerful LLMs might not need an extra system prompt to use the tool properly. llama 3.2 needs it.
        this.chatClient = ChatClient.builder(llm)
                .defaultSystem(SYSTEM_PROMPT)
                .defaultTools(new CipherTool())
                .build();
    }

    public EncryptedText ask(String question) {
        return chatClient.prompt(question).call().entity(EncryptedText.class);
    }

}
