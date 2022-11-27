import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] dateOf2007 = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dayOfDate = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        ArrayList<Integer> dateOfAcc = new ArrayList<>();
        dateOfAcc.add(0);
        for (int i = 0; i < dateOf2007.length; i++){
            dateOfAcc.add(dateOfAcc.get(dateOfAcc.size()-1)+dateOf2007[i]);
        }
        int dateNum = dateOfAcc.get(x-1)+y;
        String result = dayOfDate[dateNum%7];
        System.out.println(result);
    }
}