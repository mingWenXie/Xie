package com.hsbc.stringprocessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveTripleCharsStrategy implements StringProcessingStrategy {

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
                // 删除匹配到的连续三个或更多相同字符
                result.delete(matcher.start(), matcher.end());
                modified = true;
                System.out.println("deleted three or more consecutive identical characters：" + result.toString());
            }
        } while (modified);

        return result.toString();
    }
}
