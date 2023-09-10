import java.io.*;
import java.util.*;

//백준 4195 친구 네트워크
public class Main {

    public static int parent[];
    public static int friendCnt[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int f, idx;
        String human1, human2;
        HashMap<String, Integer> hashMap = new HashMap<>();

        while(t-- > 0){
            f = Integer.parseInt(br.readLine());
            parent = new int[f * 2];
            friendCnt = new int[f * 2];
            for(int i = 0; i < f * 2; i++) parent[i] = i;
            Arrays.fill(friendCnt, 1);
            hashMap = new HashMap<>();

            idx = 0;
            for(int i = 0; i < f; i++){
                st = new StringTokenizer(br.readLine());
                human1 = st.nextToken();
                human2 = st.nextToken();
                if(!hashMap.containsKey(human1)) hashMap.put(human1,idx++);
                if(!hashMap.containsKey(human2)) hashMap.put(human2,idx++);
                bw.write(union(hashMap.get(human1), hashMap.get(human2))+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static int union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
            friendCnt[a] += friendCnt[b];
            return friendCnt[a];
        } else if(a > b) {
            parent[a] = b;
            friendCnt[b] += friendCnt[a];
            return friendCnt[b];
        }
        return friendCnt[a];
    }
}