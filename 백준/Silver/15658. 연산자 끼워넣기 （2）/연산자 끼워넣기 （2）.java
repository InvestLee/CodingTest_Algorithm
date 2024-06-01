import java.io.*;
import java.util.*;

//15658 연산자 끼워넣기 2
public class Main {

    public static int N;
    public static int answer = 0;
    public static int plusOperand = 0, minusOperand = 0, multiplyOperand = 0, divideOperand = 0;
    public static int maxAnswer = -1000000000, minAnswer = 1000000000;
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plusOperand = Integer.parseInt(st.nextToken());
        minusOperand = Integer.parseInt(st.nextToken());
        multiplyOperand = Integer.parseInt(st.nextToken());
        divideOperand = Integer.parseInt(st.nextToken());

        simulate(1, arr[0]); //시작은 이렇게합니다.
        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    public static void simulate(int level, int sum) {
        if(level == N) {
            maxAnswer = Math.max(maxAnswer, sum);
            minAnswer = Math.min(minAnswer, sum);
            return ;
        }

        if(plusOperand > 0) {
            plusOperand -= 1;
            simulate(level + 1, sum + arr[level]);
            plusOperand += 1;
        }
        if(minusOperand > 0) {
            minusOperand -= 1;
            simulate(level + 1, sum - arr[level]);
            minusOperand += 1;
        }
        if(multiplyOperand > 0) {
            multiplyOperand -= 1;
            simulate(level + 1, sum * arr[level]);
            multiplyOperand += 1;
        }
        if(divideOperand > 0) {
            divideOperand -= 1;
            simulate(level + 1, sum / arr[level]);
            divideOperand += 1;
        }
    }
}