package com.wxmp.shell.application;

import org.springframework.shell.Input;
import org.springframework.shell.InputProvider;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author zhaohg
 * @date 2019/06/15.
 */
public class StringInputProvider implements InputProvider {
    
    private final List<String> words;
    
    private boolean done;
    
    public StringInputProvider(List<String> words) {
        this.words = words;
    }
    
    @Override
    public Input readInput() {
        if (!done) {
            done = true;
            return new Input() {
                @Override
                public List<String> words() {
                    return words;
                }
                
                @Override
                public String rawText() {
                    return StringUtils.collectionToDelimitedString(words, " ");
                }
            };
        } else {
            return null;
        }
    }
}