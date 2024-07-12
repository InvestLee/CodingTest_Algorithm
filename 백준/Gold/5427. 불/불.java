import java.io.*;
import java.util.*;

public class Main {
	public static String[][] map;
	public static Queue<Pair> people;
	public static Queue<Pair> fire;
	
	public static int size_y, size_x;
	
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(bf.readLine());

		for (int t = 0; t < test; t++) {
			String[] str = bf.readLine().split(" ");

			size_y = Integer.parseInt(str[0]);
			size_x = Integer.parseInt(str[1]);

			map = new String[size_x][size_y];

			people = new LinkedList<>();
			fire = new LinkedList<>();

			for (int i = 0; i < size_x; i++) {
				str = bf.readLine().split("");

				for (int j = 0; j < size_y; j++) {
					map[i][j] = str[j];
					
					if (map[i][j].equals("@")) {
						people.offer(new Pair(i, j, 0));
					} 
					
					if(map[i][j].equals("*")) {
						fire.offer(new Pair(i, j, 0));
					}
				}
			}
			
			while(true) { 
				if(people.size() == 0) {
					bw.write("IMPOSSIBLE" + "\n");
					break;
				} 
				
				bfsFire();
				int cnt = bfsPeople();
				
				if(cnt > 0) { 
					bw.write(cnt + "\n");
					break;
				} 
			}

		}

		bw.flush();
		bw.close();

	}
	
	public static int bfsPeople() {
		int size = people.size();
		
		while(size-- > 0) {
			Pair p = people.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(check(nx, ny)) {
					return p.dept + 1;
				}
				
				if(map[nx][ny].equals("#") || map[nx][ny].equals("*")) continue;
				
				if(map[nx][ny].equals(".")) {
					map[nx][ny] = "@";
					
					people.offer(new Pair(nx, ny, p.dept + 1));
				}

			}
		}
		
		return -1;

	}
	
	public static void bfsFire() {

		int size = fire.size();
		
		while(size-- > 0) {
			Pair p = fire.poll();

			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if(check(nx, ny)) continue;

				if(map[nx][ny].equals("#")) continue;

				if(map[nx][ny].equals(".") || map[nx][ny].equals("@")) {
					map[nx][ny] = "*";
					
					fire.offer(new Pair(nx, ny, p.dept + 1));
				}

			}
		}
	}
	
	public static boolean check(int nx, int ny) {
		return nx < 0 || nx >= size_x || ny < 0 || ny >= size_y;
	} 

	public static class Pair {
		int x;
		int y;
		int dept;

		public Pair(int x, int y, int dept) {
			this.x = x;
			this.y = y;
			this.dept = dept;

		}

	}

}