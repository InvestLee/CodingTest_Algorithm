import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> num_plastic = new ArrayList<>(Arrays.asList(br.readLine().split("")));
        br.close();
        //6과 9는 같으므로 6을 9로 바꿔준다.
        for (int i = 0; i < num_plastic.size(); i++){
            if (num_plastic.get(i).equals("6")) num_plastic.set(i, "9");
        }
        //9를 가장 뒤로 연기한다.
        Collections.sort(num_plastic);
        //가장 많이 중복된 숫자의 갯수와 9의 갯수
        int maxCount = 0;
        int nineCount = 0;
        for (String num : num_plastic){
            if (num.equals("9")){
                nineCount++;
            } else{
                int tempCount = (int) num_plastic.stream().filter(w->w.equals(num)).count();
                if (tempCount > maxCount) maxCount = tempCount;
            }
        }
        int result = Math.max(maxCount, nineCount/2+nineCount%2);
        System.out.println(result);
    }
}