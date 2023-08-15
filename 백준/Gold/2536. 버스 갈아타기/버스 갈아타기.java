import java.io.*;
import java.util.*;

//백준 2536 버스 갈아타기
class Bus{
    int idx, x1, y1, x2, y2, horOrVer;

    public Bus(int idx, int x1, int y1, int x2, int y2, int horOrVer){
        this.idx = idx;
        this.x1 = Math.min(x1,x2);
        this.y1 = Math.min(y1,y2);
        this.x2 = Math.max(x1,x2);
        this.y2 = Math.max(y1,y2);
        this.horOrVer = horOrVer;
    }

    public boolean isContain(int x, int y){
        if(this.horOrVer == 0 && this.x1 == x && this.y1 <= y && this.y2 >= y) return true;
        else if(this.horOrVer == 1 && this.y1 == y && this.x1 <= x && this.x2 >= x) return true;
        return false;
    }

    public boolean isContain(Bus b){
        if(this.horOrVer == 0 && b.horOrVer == 0){
            if (this.x1 != b.x1 || this.y1 > b.y2 || this.y2 < b.y1) return false;
            return true;
        } else if(this.horOrVer == 1 && b.horOrVer == 1){
            if (this.y1 != b.y1 || this.x1 > b.x2 || this.x2 < b.x1) return false;
            return true;
        } else if(this.horOrVer == 0 && b.horOrVer == 1){
            if (this.x1 >= b.x1 && this.x1 <= b.x2 && b.y1 >= this.y1 && b.y1 <= this.y2) return true;
            return false;
        } else {
            if (this.y1 >= b.y1 && this.y1 <= b.y2 && b.x1 >= this.x1 && b.x1 <= this.x2) return true;
            return false;
        }
    }
}

public class Main {

    public static int m, n, k, sx, sy, ex, ey;
    public static Bus[] bus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        bus = new Bus[k+1];

        int idx, x1, y1, x2, y2;
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            idx = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            if(x1==x2) bus[idx] = new Bus(idx, x1, y1, x2, y2, 0);
            else bus[idx] = new Bus(idx, x1, y1, x2, y2, 1);
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        bw.write(bfs()+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int bfs(){
        int result = 0;

        Queue<Bus> q= new LinkedList<>();
        int[] countBus = new int[k+1];

        for(int i = 1; i <= k; i++){
            if(bus[i].isContain(sx,sy)){
                q.add(bus[i]);
                countBus[i] = 1;
            }
        }

        Bus now;
        while(!q.isEmpty()){
            now = q.poll();
            if(now.isContain(ex,ey)){
                result = countBus[now.idx];
                break;
            }
            for(int i = 1; i <= k; i++){
                if(countBus[i] != 0 || !now.isContain(bus[i])) continue;
                q.add(bus[i]);
                countBus[i] = countBus[now.idx] + 1;
            }
        }
        return result;
    }
}
