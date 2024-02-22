import java.io.*;
import java.util.*;

//2635 수 이어가기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> now;

        int first, second, temp;
        for(int i = 1; i <= n; i++){
            now = new ArrayList<>();
            now.add(n);
            now.add(i);
            first = n;
            second = i;
            while(true){
                temp = first - second;
                if(temp < 0) break;
                else now.add(temp);
                first = second;
                second = temp;
            }
            if(result < now.size()){
                arrayList = now;
                result = now.size();
            }
        }
        sb.append(result).append("\n");
        for(int i = 0; i < arrayList.size(); i++){
            sb.append(arrayList.get(i) + " ");
        }
        System.out.print(sb);
    }
}