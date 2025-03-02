package de.bsi.udemyai4business.chat.config;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.boot.http.client.ClientHttpRequestFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Configuration
public class ChatModelConfig {

    @Bean
    @Primary
    public ChatModel ollamaWithBiggerTimeoutSettings(ChatModel llm) {
        if (!(llm instanceof OllamaChatModel))
            return llm;

        var factory = ClientHttpRequestFactoryBuilder.simple().withCustomizer(c -> {
            c.setConnectTimeout(Duration.ofSeconds(60));
            c.setReadTimeout(Duration.ofSeconds(60));
        }).build();
        var ollamaApi = new OllamaApi("http://localhost:11434", RestClient.builder().requestFactory(factory), WebClient.builder());
        return OllamaChatModel.builder().ollamaApi(ollamaApi).build();
    }

}
