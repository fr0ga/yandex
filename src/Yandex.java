import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by fr0ga on 17.05.2015.
 */
public class Yandex {

    public static void main(String[] args) {

        String[] input = new String[3];


        String line;
        InputStream fistream;
        int l = 0;
        try {
            fistream = new FileInputStream("input.txt");
            InputStreamReader istream = new InputStreamReader(fistream, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(istream);

            while ((line = br.readLine()) != null) {
                input[l] = line;
                l += 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = input[0].split(" ");
        String[] dictionary = input[2].split(" ");

        int checkedWords = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < dictionary.length; j++) {

                if (words[i].equals(dictionary[j])) {
                    checkedWords += 1;
                }

            }
        }

        if (checkedWords == words.length) {
            try (PrintStream out = new PrintStream(new FileOutputStream("output.txt"))) {
                out.print("Correct");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try (PrintStream out = new PrintStream(new FileOutputStream("output.txt"))) {
                out.print("Misspell");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }
}
