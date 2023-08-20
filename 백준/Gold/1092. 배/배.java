import java.io.*;
import java.util.*;

//백준 1092 배
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];
        int[] maxWork = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) crane[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] boxes = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) boxes[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(crane);
        Arrays.sort(boxes);
        int nextCrane = 0;
        for(int i = 0; i < m; i++){
            for(int j = nextCrane; j < n; j++){
                if(boxes[i] <= crane[j]){
                    maxWork[j]++;
                    break;
                }
                nextCrane++;
            }
        }

        int tempSum;
        boolean isComplete = true;
        while(isComplete){
            isComplete = false;
            for(int i = 1; i < n; i++){
                if(maxWork[i-1] > maxWork[i]){
                    tempSum = maxWork[i-1] + maxWork[i];
                    maxWork[i-1] = tempSum / 2;
                    maxWork[i] = tempSum / 2 + tempSum % 2;
                    isComplete = true;
                }
            }
        }

        if(boxes[m-1] > crane[n-1]) bw.write(-1+"");
        else bw.write(maxWork[n-1]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
