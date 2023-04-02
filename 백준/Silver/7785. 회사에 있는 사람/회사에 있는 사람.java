import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String emp, comm;
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            emp = st.nextToken();
            comm = st.nextToken();
            if (comm.equals("enter")) hashSet.add(emp);
            else hashSet.remove(emp);
        }
        ArrayList<String> arr = new ArrayList<>(hashSet);
        arr.sort(Comparator.reverseOrder());
        for(int i = 0; i < arr.size(); i++) System.out.println(arr.get(i));
    }
}
