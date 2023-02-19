import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int[][] board = new int[9][9];
    public static boolean[][] rows = new boolean[9][10];
    public static boolean[][] columns = new boolean[9][10];
    public static boolean[][] threeBoard = new boolean[9][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            String str = br.readLine();
            for(int j = 0; j < 9; j++){
                board[i][j] = str.charAt(j) - '0';
                rows[i][board[i][j]] = true;
                columns[j][board[i][j]] = true;
                threeBoard[3*(i/3)+(j/3)][board[i][j]] = true;
            }
        }
        sudoku(0);
    }

    public static void  sudoku(int idx){
        if (idx >= 81){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++) sb.append(board[i][j]+"");
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        int r = idx / 9;
        int c = idx % 9;
        if (board[r][c] != 0) sudoku(idx + 1);
        else{
            for (int i = 1; i < 10; i++){
                if (rows[r][i] || columns[c][i] || threeBoard[3*(r/3)+(c/3)][i]) continue;
                rows[r][i] = true;
                columns[c][i] = true;
                threeBoard[3*(r/3)+(c/3)][i] = true;
                board[r][c] = i;
                sudoku(idx+1);
                rows[r][i] = false;
                columns[c][i] = false;
                threeBoard[3*(r/3)+(c/3)][i] = false;
                board[r][c] = 0;
            }
        }
    }
}