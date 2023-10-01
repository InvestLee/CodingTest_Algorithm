import java.io.*;

//백준 1356 유진수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();

        int temp1, temp2;
        String result = "NO";
        for(int i = 1; i < n.length(); i++){
            temp1 = 1;
            for(int j = 0; j < i; j++){
                temp1 *= n.charAt(j) - '0';
            }

            temp2 = 1;
            for(int j = i; j < n.length(); j++){
                temp2 *= n.charAt(j) - '0';
            }

            if(temp1 == temp2){
                result = "YES";
                break;
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}