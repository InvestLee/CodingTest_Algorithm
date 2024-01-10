import java.io.*;

//1296 팀 이름 정하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String name = br.readLine();
        int n = Integer.parseInt(br.readLine());

        String team;
        int[] cnt;
        long score;
        long maxScore = 0;
        String result = "a";
        for(int i = 0; i < n; i++){
            cnt = new int[4];
            team = br.readLine();
            for(int j = 0; j < team.length(); j++){
                if(team.charAt(j) == 'L') cnt[0]++;
                if(team.charAt(j) == 'O') cnt[1]++;
                if(team.charAt(j) == 'V') cnt[2]++;
                if(team.charAt(j) == 'E') cnt[3]++;
            }

            for(int j = 0; j < name.length(); j++){
                if(name.charAt(j) == 'L') cnt[0]++;
                if(name.charAt(j) == 'O') cnt[1]++;
                if(name.charAt(j) == 'V') cnt[2]++;
                if(name.charAt(j) == 'E') cnt[3]++;
            }

            score = 1;
            for(int j = 0; j < 3; j++){
                for(int k = j+1; k < 4; k++){
                    score *= (cnt[j]+cnt[k]);
                }
            }
            score %= 100;
            if(maxScore < score){
                maxScore = score;
                result = team;
            } else if(maxScore == score){
                if(result.compareTo(team) > 0) result = team;
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}