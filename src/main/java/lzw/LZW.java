package lzw;

import java.util.List;

public class LZW {

    private static final int DICTIONARY_SIZE = 256;

    public static List<Integer> encode(String content) {
        return Encoder.encode(content, DICTIONARY_SIZE);
    }

    public static String decode(List<Integer> compressed) {
       return Decoder.decode(compressed, DICTIONARY_SIZE);
    }
}
