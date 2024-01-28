import java.io.*;

//3460 이진수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int number;
        String num;
        while(n-- > 0){
            number = Integer.parseInt(br.readLine());
            num = Integer.toBinaryString(number);
            for(int i = num.length()-1; i >= 0; i--){
                if(num.charAt(i) == '1'){
                    bw.write(num.length()-i-1+" ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}