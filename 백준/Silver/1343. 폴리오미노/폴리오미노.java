import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String board = br.readLine();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < board.length(); i++){
            if(board.charAt(i) == '.'){
                if(cnt != 0) arrayList.add(cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        if(cnt != 0) arrayList.add(cnt);
        cnt = 0;

        int idx = 0;
        String result = "";
        while(cnt < board.length()){
            if(board.charAt(cnt) == '.'){
                result += ".";
                cnt++;
            } else {
                if(arrayList.get(idx) % 2 == 1){
                    result = "-1";
                    break;
                } else {
                    cnt += arrayList.get(idx);
                    result += "AAAA".repeat(arrayList.get(idx) / 4);
                    if(arrayList.get(idx) % 4 == 2) result += "BB";
                    idx++;
                }
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }
}
