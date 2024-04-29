import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        String[] num = new String[] {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};

        for (int i = 0; i < N; i++)
        {
            int check = 0;  
            for (int j = 0; j < 8; j++)
            {
                int count = 0;  
                for (int k = 0; k < 6; k++) {
                    if (str.charAt(k) != num[j].charAt(k)) {
                        count++;
                        if (count > 1) break;
                    }
                }
                if (count == 0 || count == 1) {
                    sb.append((char)(j+'A')); 
                    check = 1;       
                    break;
                }
            }
            if (check == 0) {
                System.out.println(i+1); 
                return;
            }
            else str = str.substring(6);
        }
        System.out.println(sb);
    }
}