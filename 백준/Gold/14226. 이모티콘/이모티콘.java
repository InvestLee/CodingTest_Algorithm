import java.io.*;
import java.util.*;

public class Main {

    public static int S;
    public static boolean[][] visited = new boolean[2001][2001];
    public static Queue<Emoticon> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());

        bfs(new Emoticon(0, 1, 0));

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(Emoticon start) {
        queue.add(start);

        while (!queue.isEmpty()) {
            start = queue.poll();
            if (start.display == S) {
                sb.append(start.time);
                break;
            }
            if (!visited[start.display][start.display]) {
                visited[start.display][start.display] = true;
                queue.add(new Emoticon(start.display, start.display, start.time + 1));
            }
            if (start.clipboard != 0 && start.display + start.clipboard <= 2000) {
                if (!visited[start.display + start.clipboard][start.clipboard]) {
                    visited[start.display + start.clipboard][start.clipboard] = true;
                    queue.add(new Emoticon(start.clipboard, start.display + start.clipboard, start.time + 1));
                }
            }
            if (start.display > 0) {
                if (!visited[start.display - 1][start.clipboard]) {
                    visited[start.display - 1][start.clipboard] = true;
                    queue.add(new Emoticon(start.clipboard, start.display - 1, start.time + 1));
                }
            }
        }
    }

    public static class Emoticon {
        int clipboard;
        int display;
        int time;

        public Emoticon(int clipboard, int display, int time) {
            this.clipboard = clipboard;
            this.display = display;
            this.time = time;
        }
    }

}