package de.bsi.udemyai4business.mcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class JiraMessageService {

    private Logger log = LoggerFactory.getLogger(JiraMessageService.class);

    @Tool(description = "Receives a Git Commit message and returns a formatted JIRA message with prefix pointing to a Jira ticket.")
    public String createJiraMessage(@ToolParam(description = "Git Commit message, which describes changes in codebase, which are part of the commit.") String commitMessage) {
        var jiraMessageTemplate = "JIRA-%s: %s";
        var randomId = String.format("%06d", (int) (Math.random() * 1000000));
        var formattedMessage = jiraMessageTemplate.formatted(randomId, commitMessage);
        log.info("JIRA message generated: {}", formattedMessage);
        return formattedMessage;
    }

}
