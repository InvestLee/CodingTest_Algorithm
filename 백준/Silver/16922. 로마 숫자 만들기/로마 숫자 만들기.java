import java.io.*;
import java.util.*;

//16922 로마 숫자 만들기
public class Main {
    public static int[] arr = {1,5,10,50};
    public static int n;
    public static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        backtracking(0,0,0);
        bw.write(hashSet.size()+"");
        bw.flush();
    }

    public static void backtracking(int cnt, int sum, int idx){
        if(cnt == n){
            hashSet.add(sum);
            return;
        }
        for(int i = idx; i < 4; i++){
            backtracking(cnt+1, sum+arr[i],i);
        }
    }
}
