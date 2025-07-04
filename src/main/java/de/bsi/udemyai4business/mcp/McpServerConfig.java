package de.bsi.udemyai4business.mcp;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpServerConfig {

    @Bean
    public ToolCallbackProvider jiraTools(JiraMessageService jiraMessageService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(jiraMessageService)
                .build();
    }

}
