package com.word.counter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WordCounter {

    private ConcurrentMap<String,Integer> wordToCount = new ConcurrentHashMap<>();

    public int count(String word) {
        String wordInLowerCase = word.toLowerCase();
        Integer count = wordToCount.get(wordInLowerCase);
        if(count != null) {
            return count;
        }
        return 0;
    }

    public void accept(String word) {
        String wordInLowerCase = word.toLowerCase();
        Integer count = wordToCount.putIfAbsent(wordInLowerCase, 1);
        if (count != null) {
            wordToCount.replace(wordInLowerCase, count, count+1);
        }

    }
}
