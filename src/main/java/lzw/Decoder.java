package lzw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Decoder {

    static String decode(List<Integer> compressed, int dictionarySize) {
        Map<Integer, String> dictionary = buildDictionary(dictionarySize);

        Integer pk = compressed.remove(0);
        StringBuilder builder = new StringBuilder(dictionary.get(pk));

        for (int k : compressed) {
            String pc = dictionary.get(pk);
            if (dictionary.containsKey(k)) {
                dictionary.put(dictionarySize++, pc + dictionary.get(k).charAt(0));
                builder.append(dictionary.get(k));
            } else {
                dictionary.put(dictionarySize++, pc + pc.charAt(0));
                builder.append(pc).append(pc.charAt(0));
            }
            pk = k;
        }

        return builder.toString();
    }

    private static Map<Integer, String> buildDictionary(int dictionarySize) {
        Map<Integer, String> dict = new HashMap<>();
        IntStream.range(0, dictionarySize)
                .forEach(value -> dict.put(value, String.valueOf((char)value)));
        return dict;
    }
}
