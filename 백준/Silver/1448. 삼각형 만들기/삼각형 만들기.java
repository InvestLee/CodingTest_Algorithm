import java.io.*;
import java.util.*;

//1448 삼각형 만들기
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) arr.add(Integer.parseInt(br.readLine()));
        arr.sort(Comparator.reverseOrder());
        int result = -1;
        for(int i = 2; i < n; i++){
            if(arr.get(i)+arr.get(i-1) > arr.get(i-2)){
                result = arr.get(i) + arr.get(i-1) + arr.get(i-2);
                break;
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}
