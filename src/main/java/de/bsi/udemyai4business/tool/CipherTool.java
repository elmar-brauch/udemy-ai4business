package de.bsi.udemyai4business.tool;

import org.springframework.util.StringUtils;

import java.util.logging.Logger;

public class CipherTool {

    // TODO Convert this in a tool (e.g. with annotations)
    public String encrypt(String text) {
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
