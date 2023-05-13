import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] cake = new int[l+1];
        StringTokenizer st;
        int start, end, tempRealMaxValue;
        int predictionResult = 0;
        int realResult = 0;
        int predictMaxValue = 0;
        int realMaxValue = 0;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            if (end-start+1 > predictMaxValue){
                predictMaxValue = end-start+1;
                predictionResult = i;
            }
            tempRealMaxValue = end-start+1;
            for(int j = start; j <= end; j++){
                if(cake[j] == 0) cake[j] = 1;
                else tempRealMaxValue--;
            }
            if (tempRealMaxValue > realMaxValue){
                realMaxValue = tempRealMaxValue;
                realResult = i;
            }
        }
        System.out.println(predictionResult);
        System.out.println(realResult);
    }
}
