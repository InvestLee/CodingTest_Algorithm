import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        String book;
        while (n-- > 0){
            book = br.readLine();
            if(hashMap.containsKey(book)) hashMap.replace(book, hashMap.get(book)+1);
            else hashMap.put(book, 1);
        }

        int max = 0;
        for(int i : hashMap.values()) {
            if (max < i) max = i;
        }

        ArrayList<String> bestSeller = new ArrayList<>();
        for(String s : hashMap.keySet()) {
            if (max == hashMap.get(s)) bestSeller.add(s);
        }

        bestSeller.sort(Comparator.naturalOrder());
        System.out.println(bestSeller.get(0));
    }
}
