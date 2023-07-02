import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arrayList.add(Integer.parseInt(st.nextToken()));
        arrayList.sort(Comparator.naturalOrder());

        int start = 0;
        int end = n-1;
        int result = 0;
        while(start < end){
            if(arrayList.get(start)+arrayList.get(end) == m){
                result++;
                start++;
            }
            else if(arrayList.get(start)+arrayList.get(end) < m) start++;
            else end--;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
