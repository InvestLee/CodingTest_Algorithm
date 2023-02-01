import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][4];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                arr[i][j] = st.nextToken();
            }
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[1].equals(o2[1])){
                    if(o1[2].equals(o2[2])){
                        if(o1[3].equals(o2[3])){
                            return o1[0].compareTo(o2[0]);
                        }
                        return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        for(int i = 0; i < n; i++){
            System.out.println(arr[i][0]);
        }
    }
}