package de.bsi.udemyai4business.config;

import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.ai.model.azure.openai.autoconfigure.AzureOpenAIClientBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Configuration
public class SslConfig {

    @Bean
    public AzureOpenAIClientBuilderCustomizer trustAllSslCustomizer() throws SSLException {
        var sslContext = SslContextBuilder.forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        var reactorHttpClient = HttpClient.create()
                .secure(spec -> spec.sslContext(sslContext));
        var azureHttpClient = new NettyAsyncHttpClientBuilder(reactorHttpClient).build();
        return builder -> builder.httpClient(azureHttpClient);
    }
}
