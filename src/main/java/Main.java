import lzw.LZW;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String content = args[0];

        System.out.println("Oryginalny tekst");
        System.out.println("Rozmiar: " + content.length() + ", Zawartość: \"" + content + "\"");
        System.out.println();

        List<Integer> compressedContent = LZW.encode(content);

        System.out.println("Po kompresji");
        System.out.println("Rozmiar: " + compressedContent.size() + ", Zawartość: " + compressedContent);
        System.out.println();

        String decompressedContent = LZW.decode(compressedContent);

        System.out.println("Po dekompresji");
        System.out.println("Rozmiar: " + decompressedContent.length() + ", Zawartość: \"" + decompressedContent + "\"");
    }
}
