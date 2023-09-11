import java.io.*;
import java.util.*;

class Node{
    int left;
    int right;

    public Node(int left, int right){
        this.left = left;
        this.right = right;
    }
}

//백준 2250 트리의 높이와 너비
public class Main {
    public static ArrayList<Node>[] tree;
    public static ArrayList<Integer>[] rowNum;
    public static int height = 1, row = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        rowNum = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
            rowNum[i] = new ArrayList<>();
        }

        int[] numParent = new int[n+1];
        int self, left, right;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            self = Integer.parseInt(st.nextToken());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());

            if(left != -1) numParent[left]++;
            if(right != -1) numParent[right]++;
            tree[self].add(new Node(left, right));
        }

        int root = -1;
        for(int i = 1; i <= n; i++){
            if(numParent[i] == 0){
                root = i;
                break;
            }
        }
        inOrder(root);

        int maxWidth = -1, level = 0;
        int curWidth, len;
        for(int i = 1; i <= n; i++){
            len = rowNum[i].size();
            if(len > 0){
                curWidth = rowNum[i].get(len-1) - rowNum[i].get(0) + 1;
                if(maxWidth < curWidth){
                    maxWidth = curWidth;
                    level = i;
                }
            }
        }

        bw.write(level+" "+maxWidth);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void inOrder(int node){
        for(Node cur : tree[node]){
            if(cur.left != -1){
                height++;
                inOrder(cur.left);
            }
            row++;
            rowNum[height].add(row);
            if(cur.right != -1){
                height++;
                inOrder(cur.right);
            }
            height--;
        }
    }
}