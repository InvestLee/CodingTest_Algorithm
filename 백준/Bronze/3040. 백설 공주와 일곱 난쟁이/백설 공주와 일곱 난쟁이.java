import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static int[] dwarf;
    public static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new int[9];
        total = 0;
        for(int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            total += dwarf[i];
        }
        HashSet<Integer> result = spy();
        for(int i = 0; i < 9; i++){
            if (!result.contains(dwarf[i])) System.out.println(dwarf[i]);
        }
    }

    public static HashSet spy(){
        HashSet<Integer> result = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for (int j = i+1; j < 9; j++){
                if (total - dwarf[i] - dwarf[j] == 100){
                    result.add(dwarf[i]);
                    result.add(dwarf[j]);
                    return result;
                }
            }
        }
        return result;
    }
}