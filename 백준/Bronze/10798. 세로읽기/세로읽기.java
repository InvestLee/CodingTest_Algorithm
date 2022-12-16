import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [][] input_c = new String[5][15];
        for (int i = 0; i < 5; i++){
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++){
                input_c[i][j] = temp.substring(j,j+1);
            }
        }

        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 5; j++){
                if (input_c[j][i] == null) continue;
                System.out.print(input_c[j][i]);
            }
        }
    }
}