import java.io.*;

//6359 만취한 상범
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        int n, result;
        int[] jail;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            jail = new int[n+1];
            for(int i = 1; i <= n; i++){
                for(int j = i; j <= n; j += i){
                    if(jail[j] == 0) jail[j] = 1;
                    else jail[j] = 0;
                }
            }

            result = 0;
            for(int i = 1; i <= n; i++){
                if(jail[i] == 1) result++;
            }
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}