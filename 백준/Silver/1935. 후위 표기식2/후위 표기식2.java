import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        Stack<Double> stack = new Stack<>();
        double[] arr = new double[n];
        char operand;
        double a, b;

        for(int i = 0; i < n; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        for(int i = 0; i < postfix.length(); i++){
            operand = postfix.charAt(i);
            if(65 <= operand+0 && operand+0 <= 90){
                stack.add(arr[operand-'A']);
                continue;
            }
            a = stack.pop();
            b = stack.pop();
            if(operand == '*') stack.add(b * a);
            if(operand == '/') stack.add(b / a);
            if(operand == '+') stack.add(b + a);
            if(operand == '-') stack.add(b - a);
        }
        bw.write(String.format("%.2f",stack.pop()));
        bw.flush();
        bw.close();
    }
}
