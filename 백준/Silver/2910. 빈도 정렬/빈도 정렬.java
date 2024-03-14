import java.io.*;
import java.util.*;

//2910 빈도 정렬
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> original = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
            original.add(arr.get(i));
            hashMap.put(arr.get(i), hashMap.getOrDefault(arr.get(i),0) + 1);
        }

        Collections.sort(arr, (o1, o2) -> {
            if(hashMap.get(o1) == hashMap.get(o2)){
                return original.indexOf(o1) - original.indexOf(o2);
            } else {
                return Integer.compare(hashMap.get(o2), hashMap.get(o1));
            }
        });

        for(int i = 0; i < n; i++) {
            bw.write(arr.get(i) + " ");
        }
        bw.flush();
    }
}
