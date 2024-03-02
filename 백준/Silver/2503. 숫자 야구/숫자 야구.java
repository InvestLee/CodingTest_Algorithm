import java.io.*;
import java.util.*;

//2503 숫자 야구
public class Main {

    public static ArrayList<Number> arrayList;

    public static class Number{
        int num;
        int strike;
        int ball;

        public Number(int num, int strike, int ball){
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arrayList = new ArrayList<>();

        int num, strike, ball;
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            strike = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());
            arrayList.add(new Number(num, strike, ball)); // 질문
        }

        int result = 0;
        int a, b, c;
        for(int i = 123; i < 988; i++){
            a = i / 100;
            b = i / 10 - (a * 10);
            c = i % 10;
            if(a == 0 || b == 0 || c == 0 || a == b || a == c || b == c) continue;
            if(find(a,b,c)) result++;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static boolean find(int a, int b, int c){
        Number number;

        int q1, q2, q3, strike, ball;
        for(int i = 0; i < arrayList.size(); i++){
            number = arrayList.get(i);
            q1 = number.num / 100;
            q2 = number.num / 10 - (q1 * 10);
            q3 = number.num % 10;

            strike = 0;
            ball = 0;

            if(a == q1) strike++;
            if(b == q2) strike++;
            if(c == q3) strike++;

            if(a == q2 || a == q3) ball++;
            if(b == q1 || b == q3) ball++;
            if(c == q1 || c == q2) ball++;

            if(number.strike != strike || number.ball != ball) return false;
        }
        return true;
    }
}