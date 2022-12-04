import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input_sentence;
        while ((input_sentence = br.readLine()) != null){
            System.out.println(input_sentence);
        }
    }
}