import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, String> hashMap = new HashMap<>();
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 1; i < months.length; i++) months[i] += months[i-1];
        StringTokenizer st;
        String name;
        int birth, day, month, year;
        int maxValue = 0;
        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            birth = day + months[month-1] + year * 365;
            hashMap.put(birth, name);
        }

        for(int num : hashMap.keySet()){
            maxValue = Math.max(maxValue,num);
            minValue = Math.min(minValue,num);
        }

        bw.write(hashMap.get(maxValue)+"\n"+hashMap.get(minValue));
        bw.flush();
        bw.close();
    }
}
