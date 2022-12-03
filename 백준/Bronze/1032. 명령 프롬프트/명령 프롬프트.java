import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(br.readLine());
        for (int i = 0; i < n-1 ; i++){
            StringBuilder temp_sb = new StringBuilder(br.readLine());
            for (int j = 0; j < sb.length(); j++){
                if (sb.charAt(j) != temp_sb.charAt(j)) sb.replace(j,j+1,"?");
            }
        }
        System.out.println(sb);
    }
}