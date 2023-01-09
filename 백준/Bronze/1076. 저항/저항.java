import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Long> colorValue = new HashMap<>();
        colorValue.put("black",0L);
        colorValue.put("brown",1L);
        colorValue.put("red",2L);
        colorValue.put("orange",3L);
        colorValue.put("yellow",4L);
        colorValue.put("green",5L);
        colorValue.put("blue",6L);
        colorValue.put("violet",7L);
        colorValue.put("grey",8L);
        colorValue.put("white",9L);
        Long result = colorValue.get(br.readLine()) * 10;
        result += colorValue.get(br.readLine());
        result *= (long) Math.pow(10,colorValue.get(br.readLine()));
        System.out.println(result);
    }
}