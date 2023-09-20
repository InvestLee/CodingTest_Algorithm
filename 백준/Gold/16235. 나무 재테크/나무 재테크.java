import java.io.*;
import java.util.*;

class Tree{
    int row;
    int col;
    int age;
    boolean dead;

    public Tree(int row, int col, int age){
        this.row = row;
        this.col = col;
        this.age = age;
    }

    public Tree(String[] tree){
        this.row = Integer.parseInt(tree[0]) - 1;
        this.col = Integer.parseInt(tree[1]) - 1;
        this.age = Integer.parseInt(tree[2]);
    }
}

//백준 16235 나무 재테크
public class Main {

    public static int n, m, k;
    public static int[][] food, map;
    public static ArrayList<Tree> tree = new ArrayList<>();
    public static Deque<Integer> dead = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        food = new int[n][n];
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                food[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        String[] temp;
        for(int i = 0; i < m; i++){
            temp = br.readLine().split(" ");
            tree.add(new Tree(temp));
        }

        Collections.sort(tree, (t1, t2) -> t1.age - t2.age);

        for(int i = 0; i < k; i++){
            spring();
            summer();
            fall();
            winter();
        }

        bw.write(tree.size()+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void spring(){
        Tree t;
        for(int i = 0; i < tree.size(); i++){
            t = tree.get(i);
            if(map[t.row][t.col] < t.age){
                dead.add(i);
                continue;
            }
            map[t.row][t.col] -= t.age;
            t.age++;
        }
    }

    public static void summer(){
        int deadIdx, f;
        Tree deadTree;
        while(!dead.isEmpty()){
            deadIdx = dead.pollLast();
            deadTree = tree.get(deadIdx);
            f = deadTree.age / 2;
            map[deadTree.row][deadTree.col] += f;
            deadTree.dead = true;
        }
    }

    public static void fall(){
        int[] dr = {-1,1,0,0,-1,-1,1,1};
        int[] dc = {0,0,-1,1,-1,1,-1,1};
        ArrayList<Tree> newTree = new ArrayList<>();
        Tree t;
        int nr, nc;
        for(int i = 0; i < tree.size(); i++){
            t = tree.get(i);
            if(t.dead) continue;
            if(t.age % 5 == 0){
                for(int j = 0; j < 8; j++){
                    nr = t.row + dr[j];
                    nc = t.col + dc[j];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    newTree.add(new Tree(nr, nc, 1));
                }
            }
        }
        for(Tree tr : tree){
            if(!tr.dead) newTree.add(tr);
        }
        tree = newTree;
    }

    public static void winter(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] += food[i][j];
            }
        }
    }
}