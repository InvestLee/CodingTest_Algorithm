import java.io.*;
import java.util.*;

//17952 과제는 끝나지 않아!
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Homework> stack = new Stack<>();
        StringTokenizer st;

        int flag, score, minute, result = 0;
        Homework homework;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            flag = Integer.parseInt(st.nextToken());
            if(flag == 1){
                score = Integer.parseInt(st.nextToken());
                minute = Integer.parseInt(st.nextToken());
                if(minute == 1) result += score;
                else stack.push(new Homework(score, minute-1));
            } else if(!stack.isEmpty()){
                homework = stack.pop();
                if(homework.minute == 1) result += homework.score;
                else stack.push(new Homework(homework.score, homework.minute-1));
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}

class Homework{
    int score;
    int minute;

    public Homework(int score, int minute){
        this.score = score;
        this.minute = minute;
    }
}