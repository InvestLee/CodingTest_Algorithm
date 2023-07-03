import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String name = br.readLine();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        ArrayList<Character> arrayList = new ArrayList<>();
        char[] answer = new char[name.length()];
        char alpha;
        int odd;
        String result = "";

        for(int i = 0; i < name.length(); i++) {
            alpha = name.charAt(i);
            hashMap.put(alpha, hashMap.getOrDefault(alpha,0)+1);
        }

        for(char k : hashMap.keySet()) arrayList.add(k);
        arrayList.sort(Comparator.naturalOrder());

        if(name.length() % 2 == 1) odd = 1;
        else odd = 0;

        for(int i : hashMap.values()){
            if(i % 2 == 1) odd--;
            if(odd < 0){
                result = "I'm Sorry Hansoo";
                break;
            }
        }

        odd = 0;
        if(result.length() == 0){
            for(char a : arrayList){
                if(hashMap.get(a) % 2 == 1) answer[answer.length/2] = a;
                for(int i = odd; i < odd+hashMap.get(a)/2; i++){
                    answer[i] = a;
                    answer[name.length()-1-i] = a;
                }
                odd += hashMap.get(a)/2;
            }
            for(char a : answer) result += a;
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }
}
