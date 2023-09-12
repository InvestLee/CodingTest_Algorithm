import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 7453 합이 0인 네 정수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] abcd = new int[n][4];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                abcd[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[n*n];
        int[] cd = new int[n*n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ab[i*n+j] = abcd[i][0] + abcd[j][1];
                cd[i*n+j] = abcd[i][2] + abcd[j][3];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        int abIndex = 0;
        int cdIndex = n*n-1;
        long result = 0;
        long abValue, cdValue, abcdSum, abSameCnt, cdSameCnt;
        while(abIndex < n*n && cdIndex >= 0){
            abValue = ab[abIndex];
            cdValue = cd[cdIndex];
            abcdSum = abValue + cdValue;
            if(abcdSum < 0) abIndex++;
            else if(abcdSum > 0) cdIndex--;
            else{
                abSameCnt = 0;
                cdSameCnt = 0;
                while(abIndex < n*n && abValue == ab[abIndex]){
                    abIndex++;
                    abSameCnt++;
                }
                while(cdIndex >= 0 && cdValue == cd[cdIndex]){
                    cdIndex--;
                    cdSameCnt++;
                }
                result += abSameCnt * cdSameCnt;
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}