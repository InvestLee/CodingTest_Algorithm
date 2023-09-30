import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int val;
    int idx;

    public Node(int val, int idx){
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node o) {
        return val - o.val;
    }
}

//백준 1377 버블 소트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n+1];
        for(int i = 1; i <= n; i++){
            nodes[i] = new Node(Integer.parseInt(br.readLine()),i);
        }
        Arrays.sort(nodes,1,n+1);

        int result = 0;
        for(int i = 1; i <= n; i++){
            result = Math.max(result, nodes[i].idx - i);
        }

        bw.write((result+1)+"");
        bw.flush();
        br.close();
        bw.close();
    }
}