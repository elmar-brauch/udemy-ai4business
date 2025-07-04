package de.bsi.udemyai4business.mcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JiraMessageService {

    private Logger log = LoggerFactory.getLogger(JiraMessageService.class);

    // TODO Convert this in a tool (e.g. with annotations)
    public String createJiraMessage(String commitMessage) {
        var jiraMessageTemplate = "JIRA-%s: %s";
        var randomId = String.format("%06d", (int) (Math.random() * 1000000));
        var formattedMessage = jiraMessageTemplate.formatted(randomId, commitMessage);
        log.info("JIRA message generated: {}", formattedMessage);
        return formattedMessage;
    }

}
