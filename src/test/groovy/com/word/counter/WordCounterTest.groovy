package com.word.counter

import com.word.counter.WordCounter
import spock.lang.Specification

class WordCounterTest extends Specification {

    private WordCounter wordCounter;

    def setup() {
        wordCounter = new WordCounter()
    }

    def 'returns zero when word is not provided'() {
        given:
        String word = 'hello'

        when:
        int count = wordCounter.count(word)

        then:
        count == 0
    }

    def 'returns one when word is provided once'() {
        given:
        String word = 'good'
        wordCounter.accept(word)

        when:
        int count = wordCounter.count(word)

        then:
        count == 1
    }

    def 'returns two when word is provided twice'() {
        given:
        String word = 'bad'
        wordCounter.accept(word)
        wordCounter.accept(word)

        when:
        int count = wordCounter.count(word)

        then:
        count == 2
    }

    def 'counts words in case-insensitive mode'() {
        given:
        String word = 'Good'
        String theSameWord = 'gOoD'
        wordCounter.accept(word)

        when:
        int count = wordCounter.count(theSameWord)

        then:
        count == 1
    }


}
