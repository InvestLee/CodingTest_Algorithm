import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int ans = bfs(0,0);
		
		System.out.println(ans);
	}
	
	static int bfs(int x, int y) {
		PriorityQueue<Pos> que = new PriorityQueue<>(); 
		int minDes = Integer.MAX_VALUE;
		
		que.add(new Pos(x, y, 0));
		isVisited[x][y] = true;
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			int curX = p.x;
			int curY = p.y;
			
			if(curX == N-1 && curY == M-1) {
				minDes = Math.min(minDes, p.desCnt);
				return minDes;
			}
			
			for(int t=0; t<4; t++) {
				int nx = curX + dx[t];
				int ny = curY + dy[t];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(!isVisited[nx][ny]) {
					if(map[nx][ny] == 0) {
						que.add(new Pos(nx, ny, p.desCnt));
					} 
					if(map[nx][ny] == 1) {
						que.add(new Pos(nx, ny, p.desCnt + 1));
					}
					isVisited[nx][ny] = true;
				}
			}
			
		}
		return -1;
	}
	
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		int desCnt;
		
		Pos(int x, int y, int desCnt){
			this.x = x;
			this.y = y;
			this.desCnt = desCnt;
		}
		
		@Override
		public int compareTo(Pos o) {
			return this.desCnt - o.desCnt; 
		}
	}
	
}