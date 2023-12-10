import java.io.*;
import java.util.*;

//2628 종이자르기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        row.add(0);
        col.add(0);
        row.add(Integer.parseInt(st.nextToken()));
        col.add(Integer.parseInt(st.nextToken()));

        int n = Integer.parseInt(br.readLine());
        int flag;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            flag = Integer.parseInt(st.nextToken());
            if(flag == 0) col.add(Integer.parseInt(st.nextToken()));
            else row.add(Integer.parseInt(st.nextToken()));
        }
        row.sort(Comparator.naturalOrder());
        col.sort(Comparator.naturalOrder());

        int maxRow = 0;
        int maxCol = 0;

        for(int i = 1; i < row.size(); i++) maxRow = Math.max(maxRow, row.get(i) - row.get(i-1));
        for(int i = 1; i < col.size(); i++) maxCol = Math.max(maxCol, col.get(i) - col.get(i-1));

        bw.write(maxRow * maxCol + "");
        bw.flush();
        bw.close();
        br.close();
    }
}