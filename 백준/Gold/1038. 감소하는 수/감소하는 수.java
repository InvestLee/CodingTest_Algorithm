import java.io.*;
import java.util.*;

//백준 1038 감소하는 수
public class Main {

    public static ArrayList<Long> arr = new ArrayList<>();
    public static int n, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if(n <= 10){
            bw.write(n+"");
        } else if(n >= 1023){
            bw.write(-1+"");
        } else{
            for(int i = 0; i < 10; i++){
                dfs(i);
            }
            arr.sort(Comparator.naturalOrder());
            bw.write(arr.get(n) + "");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(long num){
        arr.add(num);
        long temp = num % 10;
        if(temp == 0) return;

        long next;
        for(long i = temp-1; i >= 0; i--){
            next = num * 10 + i;
            dfs(next);
        }
    }
}