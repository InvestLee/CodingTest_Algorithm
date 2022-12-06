import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        int num = 1;
        while (arr.size() < b){
            for (int i = 0; i < num; i++){
                arr.add(num);
            }
            num++;
        }

        ArrayList<Integer> accumulate_arr = new ArrayList<>();
        accumulate_arr.add(0);
        for (int i = 0; i < arr.size(); i++){
            accumulate_arr.add(accumulate_arr.get(accumulate_arr.size()-1)+arr.get(i));
        }
        System.out.println(accumulate_arr.get(b)-accumulate_arr.get(a-1));
    }
}