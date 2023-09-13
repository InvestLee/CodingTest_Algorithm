import java.io.*;
import java.util.*;

//백준 1495 기타리스트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int volume[] = new int[m+1];
        Arrays.fill(volume,-1);
        volume[s] = 0;

        int control[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) control[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList;
        for(int i = 1; i <= n; i++){
            arrayList = new ArrayList<>();
            for(int j = 0; j <= m; j++){
                if(volume[j] == i - 1){
                    if(0 <= j + control[i-1] && j + control[i-1] <= m) arrayList.add(j + control[i-1]);
                    if(0 <= j - control[i-1] && j - control[i-1] <= m) arrayList.add(j - control[i-1]);
                }
            }
            for(int a: arrayList) volume[a] = i;
        }

        int result = -1;
        for(int i = 0; i <= m; i++){
            if(volume[i] == n) result = Math.max(result, i);
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}