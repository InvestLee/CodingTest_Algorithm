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
        String minA = a.replaceAll("6","5");
        String minB = b.replaceAll("6","5");
        String maxA = a.replaceAll("5","6");
        String maxB = b.replaceAll("5","6");
        System.out.printf("%d %d",Integer.parseInt(minA)+Integer.parseInt(minB),Integer.parseInt(maxA)+Integer.parseInt(maxB));
    }
}
