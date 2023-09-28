import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem>{
    int deadline;
    int ramenCnt;

    public Problem(int deadline, int ramenCnt){
        this.deadline = deadline;
        this.ramenCnt = ramenCnt;
    }

    @Override
    public int compareTo(Problem o) {
        if(o.deadline == this.deadline){
            return o.ramenCnt - this.ramenCnt;
        }
        return this.deadline - o.deadline;
    }
}

//백준 1781 컵라면
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Problem> arrayList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int result = 0;
        int deadline, ramenCnt;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            deadline = Integer.parseInt(st.nextToken());
            ramenCnt = Integer.parseInt(st.nextToken());
            arrayList.add(new Problem(deadline, ramenCnt));
        }
        Collections.sort(arrayList);

        int dayCnt, min;
        for(Problem p : arrayList){
            dayCnt = pq.size();
            if(dayCnt < p.deadline){
                pq.offer(p.ramenCnt);
            } else if(dayCnt == p.deadline){
                min = pq.peek();
                if(p.ramenCnt > min){
                    pq.poll();
                    pq.add(p.ramenCnt);
                }
            }
        }
        while(!pq.isEmpty()) result += pq.poll();

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}