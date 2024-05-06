import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int bread = Integer.parseInt(st.nextToken());
        int patty = Integer.parseInt(st.nextToken());
       
        int cnt = 0;
        
        while(true) {
        	if(bread <= 1 || patty == 0) {
        		break;
        	}
        	
        	bread -= 2;
        	patty -= 1;
        	
        	cnt++;
        }
        
        System.out.println(cnt);
	}

}