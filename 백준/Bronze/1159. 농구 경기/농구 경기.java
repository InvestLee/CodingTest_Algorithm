import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Character> firstName = new ArrayList<>();
        HashMap<Character, Integer> nameCount = new HashMap<>();
        for (int i = 0; i < n ;i++){
            char firstWord = br.readLine().charAt(0);
            if (nameCount.containsKey(firstWord)){
                nameCount.put(firstWord, nameCount.get(firstWord)+1);
            } else nameCount.put(firstWord, 1);
        }
        for (char k : nameCount.keySet()) firstName.add(k);
        Collections.sort(firstName);
        String result = "";
        for (char k : firstName) if (nameCount.get(k) >= 5) result += k;
        if (result.isEmpty()) System.out.println("PREDAJA");
        else System.out.println(result);
    }
}