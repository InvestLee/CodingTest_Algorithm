import java.io.*;

//백준 2576 홀수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        int minValue = 101;
        int num;
        for(int i = 0; i < 7; i++){
            num = Integer.parseInt(br.readLine());
            if(num % 2 == 1){
                result += num;
                minValue = Math.min(minValue,num);
            }
        }
        if(result == 0) bw.write(-1+"");
        else{
            bw.write(result+"\n");
            bw.write(minValue+"");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}