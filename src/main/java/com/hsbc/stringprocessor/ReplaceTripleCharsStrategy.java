package com.hsbc.stringprocessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTripleCharsStrategy implements StringProcessingStrategy {

    /**
     * Matching three or more consecutive repeating characters
     */
    private static final Pattern TRIPLE_CHAR_PATTERN = Pattern.compile("(.)\\1{2,}");

    @Override
    public String process(String input) {
        if (input == null || input.length() < 3) {
            return input;
        }
        StringBuilder result = new StringBuilder(input);
        boolean modified;
        do {
            modified = false;
            Matcher matcher = TRIPLE_CHAR_PATTERN.matcher(result.toString());
            while (matcher.find()) {
                String match = matcher.group();
                char replacement = getReplacementChar(match.charAt(0));
                if(match.charAt(0) != 'a'){
                    result.replace(matcher.start(), matcher.end(), String.valueOf(replacement));
                }else {
                    result.delete(matcher.start(), matcher.end());
                }
                modified = true;
                System.out.println("replace them with the character：" + result.toString());
            }
        } while (modified);
        return result.toString();
    }

    private char getReplacementChar(char c) {
        if (c == 'a') {
            return 'z'; // 特殊情况：'a' 替换为 'z'
        }
        return (char) (c - 1); // 其他情况：字符减一
    }
}