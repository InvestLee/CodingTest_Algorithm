import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] road = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) road[i] = Integer.parseInt(st.nextToken());
        int start = road[0];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i < n; i++){
            if (road[i-1] >= road[i]){
                list.add(road[i-1]-start);
                start = road[i];
            }
        } if (road[n-1] > road [n-2]) list.add(road[n-1]-start);
        list.sort(Comparator.reverseOrder());
        System.out.println(list.get(0));
    }
}