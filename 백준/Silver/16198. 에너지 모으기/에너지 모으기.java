import java.io.*;
import java.util.*;

//16198 에너지 모으기
public class Main {

    public static int n, result = 0;
    public static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        backtracking(0);
        bw.write(result+"");
        bw.flush();
    }

    public static void backtracking(int sum){
        if(arr.size() == 2){
            result = Math.max(result, sum);
            return;
        }

        int removeNum, amount;
        for(int i = 1; i < arr.size()-1; i++){
            removeNum = arr.get(i);
            amount = arr.get(i-1) * arr.get(i+1);
            arr.remove(i);
            backtracking(sum + amount);
            arr.add(i, removeNum);
        }
    }
}
