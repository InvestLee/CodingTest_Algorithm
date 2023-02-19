import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<int[]> gems = new ArrayList<>();
        int[] gem;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            gem = new int[2];
            gem[0] = Integer.parseInt(st.nextToken());
            gem[1] = Integer.parseInt(st.nextToken());
            gems.add(gem);
        }

        ArrayList<Integer> bags = new ArrayList<>();
        for(int i = 0; i < k; i++) bags.add(Integer.parseInt(br.readLine()));
        bags.sort(Comparator.naturalOrder());

        gems.sort((o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        int gem_idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        for(int bag : bags){
            while(gem_idx < gems.size() && bag >= gems.get(gem_idx)[0]){
                pq.add(gems.get(gem_idx)[1]);
                gem_idx++;
            }
            if(!pq.isEmpty()) result += pq.poll();
        }
        System.out.println(result);
    }
}