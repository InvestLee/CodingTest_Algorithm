import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //스캐너는 시간 초과
        String start = br.readLine();
        Stack<Character> leftst = new Stack<>(); //좌스택 우스택 사이 커서있다고 가정
        Stack<Character> rightst = new Stack<>();
        for (int i = 0; i < start.length(); i++){
            leftst.push(start.charAt(i)); //첫 위치는 좌스택 끝
        }
        int M = Integer.parseInt(br.readLine());
        String cmd;
        for (int i = 0; i < M; i++){
            cmd = br.readLine();
            switch (cmd.charAt(0)){
                case 'L': //커서를 왼쪽으로 = 스택(좌)에서 pop한 값을 스택(우)로 push
                    if(leftst.empty()) break;
                    rightst.push(leftst.pop());
                    break;
                case 'D': //커서를 오른쪽으로 = 스택(우)에서 pop한 값을 스택(좌)로 push
                    if(rightst.empty()) break;
                    leftst.push(rightst.pop());
                    break;
                case 'B': //커서 왼쪽 글자 삭제
                    if(leftst.empty()) break;
                    leftst.pop();
                    break;
                case 'P': //글자 추가
                    leftst.push(cmd.charAt(2));
                    break;
            }
        }
        br.close();
        while(!leftst.empty()) rightst.push(leftst.pop()); //get은 시간복잡도 잡아먹음
        StringBuilder sb = new StringBuilder();
        while(!rightst.empty()) sb.append(rightst.pop());
        System.out.println(sb.toString());
    }
}