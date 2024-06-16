import java.io.*;
import java.math.BigInteger;
import java.util.*;

//2870 수학숙제
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String paper;
        String num;
        char temp;
        ArrayList<BigInteger> arr = new ArrayList<>();
        while(n-- > 0){
            paper = br.readLine();
            num = "";
            for(int i = 0; i < paper.length(); i++){
                temp = paper.charAt(i);
                if(temp >= '0' && temp <= '9'){
                    num += temp;
                } else {
                    if(num.length() > 0) arr.add(new BigInteger(num));
                    num = "";
                }

                if(i == paper.length() - 1){
                    if(num.length() > 0) arr.add(new BigInteger(num));
                    num = "";
                }
            }
        }

        arr.sort(Comparator.naturalOrder());
        for(int i = 0; i < arr.size(); i++){
            bw.write(arr.get(i)+"\n");
        }
        bw.flush();
    }
}