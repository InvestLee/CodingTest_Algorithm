import java.io.*;
import java.util.*;

public class Main {

    public static int k;
    public static char[] signs;
    public static boolean[] visited = new boolean[10];
    public static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        signs = new char[k];
        for (int i = 0; i < k ; i++) signs[i] = st.nextToken().charAt(0);
        dfs(0,"");

        bw.write(result.get(result.size()-1)+"\n");
        bw.write(result.get(0));
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, String num){
        if(depth == k+1){
            result.add(num);
            return;
        }
        for(int i = 0; i <= 9; i++){
            if(depth == 0 || !visited[i] && compare(num.charAt(num.length()-1)-'0',i,signs[depth-1])){
                visited[i] = true;
                dfs(depth+1,num+i);
                visited[i] = false;
            }
        }
    }

    public static boolean compare(int a, int b, char c){
        if(c == '<') return a < b;
        return a > b;
    }
}
