import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] room = new String[n];
        for(int i = 0; i < n; i++) room[i] = br.readLine();

        int row, col, row_length, col_length;
        row = col = 0;

        for(int i = 0; i < n; i++){
            row_length = 0;
            col_length = 0;
            for(int j = 0; j < n; j++){
                if (room[i].charAt(j) == '.') row_length++;
                else row_length = 0;
                if (row_length == 2) row++;

                if (room[j].charAt(i) == '.') col_length++;
                else col_length = 0;
                if (col_length == 2) col++;
            }
        }
        System.out.printf("%d %d",row,col);
    }
}
