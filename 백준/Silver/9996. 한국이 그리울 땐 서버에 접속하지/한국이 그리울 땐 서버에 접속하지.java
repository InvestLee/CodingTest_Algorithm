import java.io.*;

//9996 한국이 그리울 땐 서버에 접속하지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("\\*");

        String str, left, right;
        for(int i = 0; i < n; i++){
            str = br.readLine();
            if(arr[0].length() + arr[1].length() > str.length()){
                bw.write("NE\n");
                continue;
            }

            left = str.substring(0, arr[0].length());
            right = str.substring(str.length() - arr[1].length(), str.length());

            if(left.equals(arr[0]) && right.equals(arr[1])){
                bw.write("DA\n");
            } else {
                bw.write("NE\n");
            }
        }

        bw.flush();
    }
}