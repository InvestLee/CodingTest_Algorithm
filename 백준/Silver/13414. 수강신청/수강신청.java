import java.io.*;
import java.util.*;

//13414 수강신청
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int cnt  = 0;

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        String str;
        for(int i = 0; i < l; i++){
            str = br.readLine();
            if(linkedHashSet.contains(str)) linkedHashSet.remove(str);
            linkedHashSet.add(str);
        }

        for(String result : linkedHashSet){
            cnt++;
            bw.write(result+"\n");
            if(cnt == k) break;
        }

        bw.flush();
    }
}
