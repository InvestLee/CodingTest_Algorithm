import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder n = new StringBuilder(br.readLine());
        int f = Integer.parseInt(br.readLine());
        n.setCharAt(n.length()-1,'0');
        n.setCharAt(n.length()-2,'0');
        int num = Integer.parseInt(String.valueOf(n));
        String result = "00";
        for(int i = 0; i  < 100; i++){
            if((num+i) % f == 0){
                if(i < 10) result = "0"+String.valueOf(i);
                else result = String.valueOf(i);
                break;
            }
        }
        System.out.println(result);
    }
}
