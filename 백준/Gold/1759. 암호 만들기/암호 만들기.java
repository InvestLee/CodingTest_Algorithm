import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<String> password = new ArrayList<>();
        for (int i = 0; i < c; i++){
            password.add(st.nextToken());
        }
        Collections.sort(password);
        backtracking(l,c,password,0);
    }

    public static void backtracking(int l, int c, ArrayList<String> password, int start){
        if (stack.size() == l && isValid()) System.out.println(String.join("",stack));
        for (int i = start; i < c; i++){
            if (stack.contains(password.get(i))) continue;
            stack.add(password.get(i));
            backtracking(l,c,password,i+1);
            stack.pop();
        }
    }

    public static boolean isValid(){
        int mother_word = 0;
        int son_word = 0;
        for (String word : stack){
            if (word.equals("a") || word.equals("e") || word.equals("i") || word.equals("o") || word.equals("u")){
                mother_word++;
            } else {
                son_word++;
            }
        }
        if (mother_word >= 1 && son_word >= 2) return true;
        else return false;
    }
}