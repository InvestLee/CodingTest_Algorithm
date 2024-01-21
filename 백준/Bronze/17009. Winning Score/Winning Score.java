import java.io.*;

//17009 Winning Score
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] score = new int[2];
        for(int i = 0; i < 2; i++){
            for(int j = 3; j > 0; j--){
                score[i] += j*Integer.parseInt(br.readLine());
            }
        }

        if(score[0] == score[1]) bw.write("T");
        else if(score[0] > score[1]) bw.write("A");
        else if(score[0] < score[1]) bw.write("B");

        bw.flush();
        bw.close();
        br.close();
    }
}