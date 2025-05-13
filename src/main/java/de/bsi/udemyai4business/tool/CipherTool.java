package de.bsi.udemyai4business.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.util.StringUtils;

import java.util.logging.Logger;

public class CipherTool {

    @Tool(description = "Encrypt a text using an own cipher.", name = "CipherTool")
    public String encrypt(@ToolParam(description = "Text to be encrypted.") String text) {
        var encrypted = "NA";
        if (StringUtils.hasText(text))
            encrypted = text.toLowerCase()
                    .replace('a', '@')
                    .replace('e', '€')
                    .replace('i', '_')
                    .replace('o', '*')
                    .replace('u', '#');
        Logger.getLogger(CipherTool.class.getName()).info(
                "CipherTool encrypted text %s into %s".formatted(text, encrypted));
        return encrypted;
    }

}
