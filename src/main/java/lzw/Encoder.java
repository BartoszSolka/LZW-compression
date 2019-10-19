package lzw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Encoder {

    static List<Integer> encode(String content, int dictionarySize) {
        Map<String, Integer> dictionary = buildDictionary(dictionarySize);

        String w = "";
        List<Integer> result = new ArrayList<>();

        for (char character : content.toCharArray()) {
            String wc = w + character;
            if (dictionary.containsKey(wc)) {
                w  = wc;
            } else {
                result.add(dictionary.get(w));
                dictionary.put(wc, dictionarySize++);
                w = String.valueOf(character);
            }
        }

        if (!w.isEmpty()) {
            result.add(dictionary.get(w));
        }
        return result;
    }

    private static Map<String, Integer> buildDictionary(int dictionarySize) {
        Map<String, Integer> dict = new HashMap<>();
        IntStream.range(0, dictionarySize)
                .forEach(value -> dict.put(String.valueOf((char)value), value));
        return dict;
    }
}
