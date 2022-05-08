import java.util.*;
import java.io.*;

public class Main{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long a = Integer.parseInt(input[0]);
		long b = Integer.parseInt(input[1]);
		long c = Integer.parseInt(input[2]);
		if (a*b-c < 0) System.out.println(0);
		else System.out.println(a*b-c);
	}
}