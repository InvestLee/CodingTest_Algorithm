import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int num  =Integer.parseInt(st.nextToken());
            arr[i] = num;

            if(!map.containsKey(num)){
                map.put(num, 1);
            } else{
                map.put(num, map.get(num)+1);
            }
        }


        for(int i=0; i<N; i++){

            while ((!stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i]))) {
                arr[stack.peek()] = arr[i];
                stack.pop();
            }

            stack.push(i);
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        for(int num : arr){
            bw.write(num+" ");
        }
        bw.flush();
        bw.close();
    }
}