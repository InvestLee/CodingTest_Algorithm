import java.io.*;
import java.util.*;

//백준 15803 PLAYERJINAH’S BOTTLEGROUNDS
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        double[][] loc = new double[3][2];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                loc[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(loc[0][0] == loc[1][0] || loc[1][0] == loc[2][0] || loc[0][0] == loc[2][0]){
            if(loc[0][0] == loc[1][0] && loc[1][0] == loc[2][0]) bw.write("WHERE IS MY CHICKEN?");
            else bw.write("WINNER WINNER CHICKEN DINNER!");
        }else if(loc[0][1] == loc[1][1] || loc[1][1] == loc[2][1] || loc[0][1] == loc[2][1]){
            if(loc[0][1] == loc[1][1] && loc[1][1] == loc[2][1]) bw.write("WHERE IS MY CHICKEN?");
            else bw.write("WINNER WINNER CHICKEN DINNER!");
        }else{
            if((loc[1][1] - loc[0][1]) / (loc[1][0] - loc[0][0]) == (loc[2][1] - loc[0][1]) / (loc[2][0] - loc[0][0])) bw.write("WHERE IS MY CHICKEN?");
            else bw.write("WINNER WINNER CHICKEN DINNER!");
        }

        bw.write("");
        br.close();
        bw.flush();
        bw.close();
    }
}