import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb1 = new StringBuilder(st.nextToken());
        StringBuilder sb2 = new StringBuilder(st.nextToken());
        int temp = Integer.parseInt(String.valueOf(sb1.reverse()))+Integer.parseInt(String.valueOf(sb2.reverse()));
        StringBuilder result = new StringBuilder(String.valueOf(temp));
        System.out.println(Integer.parseInt(String.valueOf(result.reverse())));
    }
}