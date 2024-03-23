import java.io.*;
import java.util.*;

//12891 DNA 비밀번호
public class Main {

    public static char[] acgt = {'A','C','G','T'};
    public static HashMap<Character, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        st = new StringTokenizer(br.readLine());

        for(char c : acgt){
            map.put(c,new int[]{0,Integer.parseInt(st.nextToken())});
        }

        for(int i = 0; i < p; i++){
            map.get(dna.charAt(i))[0]++;
        }
        if(isFull()) result++;

        for(int i = 0; i < s-p; i++){
            map.get(dna.charAt(i))[0] -= 1;
            map.get(dna.charAt(i+p))[0] += 1;
            if(isFull()) result++;
        }
        bw.write(result+"");
        bw.flush();
    }

    public static boolean isFull(){
        for(char c : acgt){
            if(map.get(c)[0] < map.get(c)[1]){
                return false;
            }
        }
        return true;
    }
}
