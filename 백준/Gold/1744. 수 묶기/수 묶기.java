import java.io.*;
import java.util.*;

//백준 1744 수 묶기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> pNum = new ArrayList<>();
        ArrayList<Integer> nNum = new ArrayList<>();
        int num;
        int result = 0;
        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if(num == 1) result += num;
            else if(num > 1) pNum.add(num);
            else nNum.add(num);
        }

        pNum.sort(Comparator.reverseOrder());
        nNum.sort(Comparator.naturalOrder());

        int idx = 0;
        while(idx < pNum.size()){
            if(idx+1 < pNum.size()) result += pNum.get(idx++) * pNum.get(idx++);
            else result += pNum.get(idx++);
        }
        idx = 0;
        while(idx < nNum.size()){
            if(idx+1 < nNum.size()) result += nNum.get(idx++) * nNum.get(idx++);
            else result += nNum.get(idx++);
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
