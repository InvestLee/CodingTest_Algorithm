import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dic = {8,5,4,9,1,7,6,3,2,0};
		int cnt = 0;
		
		for(int i = 0; i<10; i++) {
			if(dic[i]>=M && dic[i]<=N) {
				sb.append(dic[i]).append(" ");
				if(++cnt%10 == 0) sb.append("\n");
			}
			if(dic[i]*10>=M-10) {
				for(int k = 0; k < 10; k++) {
					int num = dic[i]*10 + dic[k];
					if(num < 10 || num<M || num>N) continue;
					
					sb.append(num).append(" ");
					
					if(++cnt%10 == 0) sb.append("\n");
				}
			}
		}
		System.out.println(sb);

	}
}