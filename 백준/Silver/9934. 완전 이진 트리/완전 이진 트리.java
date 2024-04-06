import java.io.*;
import java.util.*;

//9934 완전 이진 트리
public class Main {

    public static int k, size;
    public static int[] num;
    public static ArrayList<Integer>[] tree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = (int)(Math.pow(2,k) - 1);
        tree = new ArrayList[k+1];
        num = new int[size+1];
        for(int i = 0; i <= k; i++) tree[i] = new ArrayList<>();
        int idx = 1;
        while(st.hasMoreTokens()) num[idx++] = Integer.parseInt(st.nextToken());

        inorder(1, 1, size);
        for(int i = 1; i <= k; i++){
            for(int j = 0; j < tree[i].size(); j++) bw.write(tree[i].get(j)+" ");
            bw.newLine();
        }
        bw.flush();
    }

    public static void inorder(int depth, int start, int end){
        int mid = (start + end) / 2;
        tree[depth].add(num[mid]);
        if(depth == k ) return;
        inorder(depth+1, start, mid - 1);
        inorder(depth+1, mid+1, end);
    }
}
