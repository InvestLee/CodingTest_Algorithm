import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		long ans=0;
		StringTokenizer st = new StringTokenizer(br.readLine().replaceAll("[a-zA-Z]", " "));
		while(st.hasMoreTokens())
			ans+=Integer.parseInt(st.nextToken());
		System.out.println(ans);
	}
}