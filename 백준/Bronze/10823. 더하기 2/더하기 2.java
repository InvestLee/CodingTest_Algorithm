import java.io.*;
import java.util.*;

//10823 더하기 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();
        String str;

        while((str = br.readLine()) != null){
            sb.append(str);
        }

        StringTokenizer st = new StringTokenizer(sb.toString(),",");
        while(st.hasMoreTokens()){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(arr.stream()
                .mapToInt(Integer::intValue)
                .sum()+"");
        bw.flush();
        bw.close();
        br.close();
    }
}