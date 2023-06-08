import java.io.*;

public class Main {

    public static int n;
    public static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        String candy;
        int result = 1;

        for(int i = 0; i < n; i++){
            candy = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = candy.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                change(i,j,i,j-1);
                result = Math.max(result, maxCandy());
                change(i,j,i,j-1);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                change(j,i,j-1,i);
                result = Math.max(result, maxCandy());
                change(j,i,j-1,i);
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static void change(int a, int b, int c, int d){
        char temp = arr[a][b];
        arr[a][b] = arr[c][d];
        arr[c][d] = temp;
    }

    public static int maxCandy(){
        int result = 1;
        int temp;

        for(int i = 0; i < n; i++){
            temp = 1;
            for(int j = 1; j < n; j++){
                if(arr[i][j] == arr[i][j-1]) temp++;
                else{
                    if(result < temp) result = temp;
                    temp = 1;
                }
            }
            if(result < temp) result = temp;
        }

        for(int i = 0; i < n; i++){
            temp = 1;
            for(int j = 1; j < n; j++){
                if(arr[j][i] == arr[j-1][i]) temp++;
                else{
                    if(result < temp) result = temp;
                    temp = 1;
                }
            }
            if(result < temp) result = temp;
        }

        return result;
    }
}
