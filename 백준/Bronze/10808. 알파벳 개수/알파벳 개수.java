import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 97; i <= 122; i++) {
            hashMap.put((char) i, 0);
        }
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++){
            hashMap.put(s.charAt(i), hashMap.get(s.charAt(i))+1);
        }
        for (Character c: hashMap.keySet()){
            System.out.printf("%d ",hashMap.get(c));
        }
    }
}