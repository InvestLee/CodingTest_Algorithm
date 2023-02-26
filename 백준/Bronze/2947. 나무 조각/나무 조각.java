import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int[] wood = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++) wood[i] = Integer.parseInt(st.nextToken());
        boolean naturalOrder = false;

        while(!naturalOrder){
            naturalOrder =true;
            for(int i = 0; i < 4; i++){
                if(wood[i] > wood[i+1]){
                    naturalOrder = false;
                    change(i);
                    for(int j = 0; j < 5; j++) System.out.printf("%d ",wood[j]);
                    System.out.println();
                }
            }
        }
    }

    public static void change(int i){
        int temp;
        temp = wood[i];
        wood[i] = wood[i+1];
        wood[i+1] = temp;
    }
}