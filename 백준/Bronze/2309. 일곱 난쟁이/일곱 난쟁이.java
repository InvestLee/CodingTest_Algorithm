import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<Integer> dwarf;
    public static int first_except;
    public static int second_except;
    public static int sum_height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new ArrayList<>();
        sum_height = 0;
        for (int i = 0; i < 9; i++) {
            dwarf.add(Integer.parseInt(br.readLine()));
            sum_height += dwarf.get(i);
        }
        Collections.sort(dwarf);
        setExcept();
        printDwarf();
    }

    public static void setExcept(){
        first_except = 0;
        second_except = 0;
        for (int i = 0; i < 8; i++){
            for (int j = i+1; j < 9; j++){
                int except_height = dwarf.get(i)+dwarf.get(j);
                if (sum_height-except_height == 100){
                    first_except = i;
                    second_except = j;
                    break;
                }
            }
        }
    }

    public static void printDwarf(){
        for (int i = 0; i < 9; i++){
            if (i != first_except && i != second_except){
                System.out.println(dwarf.get(i));
            }
        }
    }
}