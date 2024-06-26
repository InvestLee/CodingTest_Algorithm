import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,ntime,time,t_a,t_b,s;
        boolean chk;
        s = time = t_a = t_b = 0;
        N = Integer.parseInt(br.readLine());
        int i =0;
        while(i<N) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")){
                chk = true;
            }
            else {
                chk = false;
            }
            String str = st.nextToken();
            ntime = (str.charAt(0)-'0')*600;
            ntime += (str.charAt(1)-'0')*60;
            ntime += (str.charAt(3)-'0')*10;
            ntime += str.charAt(4)-'0';
            if(s>0){
                t_a += ntime - time;
            }
            if(s<0){
                t_b += ntime - time;
            }
            if(chk){
                s+=1;
            }
            else {
                s-=1;
            }
            time = ntime;
            i++;
        }
        if(s>0) t_a += 2880 - time;
        if(s<0) t_b += 2880 - time;
        System.out.printf("%02d:%02d",t_a/60,t_a%60);
        System.out.println();
        System.out.printf("%02d:%02d",t_b/60,t_b%60);

    }
}