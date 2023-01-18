import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> mushroom = new ArrayList<>();
        for (int i = 0; i < 10 ;i++) mushroom.add(Integer.parseInt(br.readLine()));
        for (int i = 1; i < 10 ;i++) mushroom.set(i, mushroom.get(i)+mushroom.get(i-1));
        int result = 0;
        for (int i = 0; i < 10 ; i++){
            if (Math.abs(100-result) <  Math.abs(100-mushroom.get(i))) break;
            result = mushroom.get(i);
        }
        System.out.println(result);
    }
}