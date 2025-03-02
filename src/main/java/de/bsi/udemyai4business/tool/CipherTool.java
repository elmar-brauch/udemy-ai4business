package de.bsi.udemyai4business.tool;

import org.springframework.util.StringUtils;

public class CipherTool {

    // TODO Convert this in a tool (e.g. with annotations)
    public String encrypt(String text) {
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
