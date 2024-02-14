import java.io.*;
import java.util.*;

//2755 이번학기 평점은 몇점?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.3);
        gradeMap.put("A0", 4.0);
        gradeMap.put("A-", 3.7);
        gradeMap.put("B+", 3.3);
        gradeMap.put("B0", 3.0);
        gradeMap.put("B-", 2.7);
        gradeMap.put("C+", 2.3);
        gradeMap.put("C0", 2.0);
        gradeMap.put("C-", 1.7);
        gradeMap.put("D+", 1.3);
        gradeMap.put("D0", 1.0);
        gradeMap.put("D-", 0.7);
        gradeMap.put("F", 0.0);

        int n = Integer.parseInt(br.readLine());
        String name;
        Double value, grade;
        Double result = 0.0;
        Double sumValue = 0.0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            value = Double.parseDouble(st.nextToken());
            grade = gradeMap.get(st.nextToken());
            result += value * grade;
            sumValue += value;
        }

        bw.write(String.format("%.2f",result/sumValue) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}