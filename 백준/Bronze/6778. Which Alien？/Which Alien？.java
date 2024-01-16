import java.io.*;

//6778 Which Alien?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int antenna = Integer.parseInt(br.readLine());
        int eye = Integer.parseInt(br.readLine());

        if (antenna >= 3 && eye <=4) bw.write("TroyMartian\n");
        if(antenna <= 6 && eye >= 2 ) bw.write("VladSaturnian\n");
        if(antenna <=2 && eye <= 3) bw.write("GraemeMercurian");
        bw.flush();
        bw.close();
        br.close();
    }
}