import java.io.*;
import java.util.*;

class Monster implements Comparable<Monster>{
    int x;
    int y;
    int dist;

    public Monster(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Monster o) {
        if(this.dist == o.dist){
            return this.y - o.y;
        } else{
            return this.dist - o.dist;
        }
    }
}

//백준 17135 캐슬 디펜스
public class Main {

    public static int n, m, d, result;
    public static int map[][], archer[];
    public static ArrayList<int[]> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        archer = new int[3];
        arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) arrayList.add(new int[] {i, j});
            }
        }

        locateArcher(0,0);
        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void locateArcher(int num, int start){
        if(num == 3){
            ArrayList<int[]> monsterLoc = init();
            killMonster(monsterLoc);
            return;
        }
        for(int i = start; i < m; i++){
            archer[num] = i;
            locateArcher(num+1, i+1);
        }
    }

    public static ArrayList<int[]> init(){
        ArrayList<int[]> temp = new ArrayList<>();
        for(int i = 0; i < arrayList.size(); i++){
            int[] cur = arrayList.get(i);
            temp.add(new int[] {cur[0], cur[1]});
        }
        return temp;
    }

    public static void killMonster(ArrayList<int[]> arrayList){
        int tempResult = 0;
        ArrayList<int[]> targets;
        PriorityQueue<Monster> pq;
        int[] cur, cur2;
        int dist;
        Monster target;
        boolean flag;
        while(!arrayList.isEmpty()){
            targets = new ArrayList<>();
            for(int i = 0; i < 3; i++){
                pq = new PriorityQueue<>();
                for(int j = 0; j < arrayList.size(); j++){
                    cur = arrayList.get(j);
                    dist = Math.abs(cur[0]-n) + Math.abs(cur[1] - archer[i]);
                    if(dist <= d) pq.add(new Monster(cur[0], cur[1], dist));
                }
                if(!pq.isEmpty()){
                    target = pq.poll();
                    flag = false;
                    for(int j = 0; j < targets.size(); j++){
                        cur2 = targets.get(j);
                        if(target.x == cur2[0] && target.y == cur2[1]) flag =true;
                    }
                    if(!flag) targets.add(new int[] {target.x, target.y});
                }
            }

            for(int i = 0; i < targets.size(); i++){
                for(int j = arrayList.size() - 1; j >= 0; j--){
                    if (targets.get(i)[0] == arrayList.get(j)[0] && targets.get(i)[1] == arrayList.get(j)[1]) {
                        arrayList.remove(j);
                        tempResult++;
                        break;
                    }
                }
            }

            for(int i = arrayList.size() - 1; i >= 0; i--){
                arrayList.get(i)[0] += 1;
                if(arrayList.get(i)[0] == n) arrayList.remove(i);
            }
            result = Math.max(result, tempResult);
        }
    }
}