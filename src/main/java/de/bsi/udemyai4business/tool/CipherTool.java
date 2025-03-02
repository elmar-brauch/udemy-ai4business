package de.bsi.udemyai4business.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.util.StringUtils;

public class CipherTool {

    @Tool(description = "Encrypt a text using a self-invented cipher.")
    public String encrypt(@ToolParam(description = "Text to be encrypted.") String text) {
        if (!StringUtils.hasText(text))
            return "NA";
        return text.toLowerCase()
                .replace('a', '@')
                .replace('e', '€')
                .replace('i', '_')
                .replace('o', '*')
                .replace('u', '#');
    }

}
