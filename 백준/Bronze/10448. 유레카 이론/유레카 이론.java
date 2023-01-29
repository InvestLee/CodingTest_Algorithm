import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int[] triNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        triNum = new int[45];
        for(int i = 1; i < 45; i++) triNum[i] = i * (i+1)/2;
        for(int i = 0; i < t; i++){
            int k = Integer.parseInt(br.readLine());
            eureka(k);
        }
    }

    public static void eureka(int num){
        int sum;
        for(int i = 1; i < 45; i++){
            for(int j = 1; j < 45; j++){
                for(int k = 1; k < 45; k++){
                    sum = triNum[i]+triNum[j]+triNum[k];
                    if(sum==num){
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
        return;
    }
}