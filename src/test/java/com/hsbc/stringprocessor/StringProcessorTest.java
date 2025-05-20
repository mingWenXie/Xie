package com.hsbc.stringprocessor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringProcessorTest {
    private StringProcessingStrategy removeProcessor;
    private StringProcessingStrategy replaceProcessor;

    @BeforeEach
    void setUp() {
        removeProcessor = new RemoveTripleCharsStrategy();
        replaceProcessor = new ReplaceTripleCharsStrategy();
    }

    @Test
    void testRemoveProcessor() {
        String output = removeProcessor.process("aabcccbbad");
        assertEquals("d", output);

    }
    @Test
    void testReplaceProcessor() {
        String output = replaceProcessor.process("abcccbad");
        assertEquals("d", output);
    }
}