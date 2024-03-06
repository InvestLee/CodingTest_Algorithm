import java.io.*;
import java.util.*;

//1822 차집합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++) treeSet.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++) treeSet.remove(Integer.parseInt(st.nextToken()));

        sb.append(treeSet.size()+"\n");
        for(Integer num : treeSet){
            sb.append(num+" ");
        }
        System.out.println(sb);
    }
}