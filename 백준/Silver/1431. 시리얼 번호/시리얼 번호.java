import java.io.*;
import java.util.*;

//1431 시리얼 번호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] guitar = new String[n];
        for(int i = 0; i < n; i++) guitar[i] = br.readLine();
        Arrays.sort(guitar, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    int sum1 = 0;
                    int sum2 = 0;
                    for(int i = 0; i < o1.length(); i++){
                        if(o1.charAt(i) >= '0' && o1.charAt(i) <= '9'){
                            sum1 += o1.charAt(i) - '0';
                        }
                    }
                    for(int i = 0; i < o2.length(); i++){
                        if(o2.charAt(i) >= '0' && o2.charAt(i) <= '9'){
                            sum2 += o2.charAt(i) - '0';
                        }
                    }
                    if(sum1 == sum2) return o1.compareTo(o2);
                    else return sum1 - sum2;
                }
                return o1.length() - o2.length();
            }
        });

        for(int i = 0; i < n; i++) bw.write(guitar[i]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}