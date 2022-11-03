import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String st = br.readLine();
            if (st == null || st.isEmpty()) break;
            System.out.println(st);
        }
        br.close();
    }
}