import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        boolean check;
        while(true){
            check = true;
            for(int i = 0; i < n.length(); i++){
                if(n.charAt(i) != '4' && n.charAt(i) != '7'){
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println(n);
                break;
            } else{
                n = String.valueOf(Integer.parseInt(n)-1);
            }
        }
    }
}
