import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int min = sigma(K);
        if(min > N)		
            bw.write("-1");		
        else{
            int answer = K-1;
            N -= min;		
            if(N%K != 0)	
                answer++;		
            bw.write(answer + "");
        }
        bw.flush();		
        bw.close();
        br.close();
    }

    static int sigma(int n){
        int result = 0;
        for(int i=1;i<=n;i++)
            result += i;
        return result;
    }
}