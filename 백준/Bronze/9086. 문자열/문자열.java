import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++){
            String st = br.readLine();
            System.out.print(st.charAt(0));
            System.out.print(st.charAt(st.length()-1));
            System.out.println();
        }
        br.close();
    }
}