import java.io.*;
import java.util.*;

//4641 Doubles
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayList<Integer> arr;
        int temp;
        int result;

        while(true){
            st = new StringTokenizer(br.readLine());
            arr = new ArrayList<>();
            temp = Integer.parseInt(st.nextToken());
            if(temp == -1) break;
            arr.add(temp);

            while(st.countTokens() > 0){
                temp = Integer.parseInt(st.nextToken());
                if(temp == 0) break;
                arr.add(temp);
            }
            Collections.sort(arr);

            result = 0;
            for(int i = 0; i < arr.size()-1; i++){
                for(int j = i+1; j < arr.size(); j++){
                    if(arr.get(i) * 2 == arr.get(j)) result++;
                    else if(arr.get(i) * 2 < arr.get(j)) break;
                }
            }
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}