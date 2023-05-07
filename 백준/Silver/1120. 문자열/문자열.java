import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int cnt  = b.length() - a.length() + 1;
        int min = 51;
        int temp_min;
        for(int i = 0; i <  cnt; i++){
            temp_min = 0;
            for(int j = 0; j < a.length(); j++){
                if (a.charAt(j)  != b.charAt(i+j)) temp_min++;
            }
            min = Math.min(min,temp_min);
        }
        System.out.println(min);
    }
}
