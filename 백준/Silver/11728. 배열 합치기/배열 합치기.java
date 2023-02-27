import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr1[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) arr2[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb =new StringBuilder();
        int i=0;
        int j=0;
        while(i<n && j<m) {
            if(arr1[i]<arr2[j]) {
                sb.append(arr1[i++]+" ");
            }else {
                sb.append(arr2[j++]+" ");
            }
        }

        while(i<n) {
            sb.append(arr1[i++]+" ");
        }
        while(j<m) {
            sb.append(arr2[j++]+" ");
        }

        System.out.println(sb.toString());
    }
}