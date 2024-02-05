import java.io.*;
import java.util.StringTokenizer;

//11098 첼시를 도와줘
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int p, cost, max;
        String name, result;
        StringTokenizer st;
        while(n-- > 0){
            result = "";
            max = 0;
            p = Integer.parseInt(br.readLine());
            for(int i = 0; i < p; i++){
                st = new StringTokenizer(br.readLine());
                cost = Integer.parseInt(st.nextToken());
                name = st.nextToken();
                if(max < cost){
                    max = cost;
                    result = name;
                }
            }
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}