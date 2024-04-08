import java.io.*;
import java.util.*;

//1713 후보 추천하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> frame = new ArrayList<>();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[m];
        for(int i = 0; i < m; i++) input[i] = Integer.parseInt(st.nextToken());

        int[] student = new int[101];
        int min, minVal, minIdx;
        for(int i = 0; i < m; i++){
            if(student[input[i]]==0){
                if(frame.size() < n){
                    frame.add(input[i]);
                    student[input[i]]++;
                } else {
                    min = 0;
                    minVal = Integer.MAX_VALUE;
                    minIdx = 0;
                    for(int j = 0; j < frame.size(); j++){
                        if(minVal > student[frame.get(j)]){
                            minVal = student[frame.get(j)];
                            min = frame.get(j);
                            minIdx = j;
                        }
                    }
                    student[min] = 0;
                    frame.remove(minIdx);
                    frame.add(input[i]);
                    student[input[i]]++;
                }
            } else {
              student[input[i]]++;
            }
        }
        frame.sort(Comparator.naturalOrder());
        for(int i = 0; i < frame.size(); i++) bw.write(frame.get(i)+" ");
        bw.flush();
    }
}
