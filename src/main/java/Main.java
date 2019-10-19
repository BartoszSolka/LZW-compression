import lzw.LZW;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String content = args[0];
        List<Integer> compressedContent = LZW.encode(content);
        String decompressedContent = LZW.decode(compressedContent);

        System.out.println(content);
        System.out.println(compressedContent);
        System.out.println(decompressedContent);
    }
}
