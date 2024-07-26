import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int peoples[]; 
	static List<ArrayList<Integer>> graph;
	static boolean selected[];
	static boolean visited[];
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		res = Integer.MAX_VALUE; 
		peoples = new int[N]; 
		selected = new boolean[N]; 

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			peoples[i] = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken()); 
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph.get(i).add(num - 1);
			}
		}

		divide(0);
		if (res == Integer.MAX_VALUE)
			res = -1;
		System.out.println(res);

	}

	private static void divide(int idx) { 
		if (idx == N) {
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (selected[i])
					aList.add(i);
				else
					bList.add(i);
			}
			if (aList.size() == 0 || bList.size() == 0) 
				return;
			
			if (check(aList) && check(bList)) { 
				getPeopleDiff(); 
			}
			return;
		}

		selected[idx] = true;
		divide(idx + 1);
		selected[idx] = false;
		divide(idx + 1);

	}

	private static boolean check(List<Integer> list) {

		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N];
		visited[list.get(0)] = true;
		q.offer(list.get(0));
		
		int count = 1; 
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int y = graph.get(cur).get(i);
				if(list.contains(y) && !visited[y]) { 
					q.offer(y);
					visited[y] = true;
					count ++;
				}
			}
		}
		if(count==list.size()) 
			return true;
		else
			return false;
	}


	private static void getPeopleDiff() { 
		int pA = 0, pB = 0;
		for (int i = 0; i < N; i++) {
			if (selected[i])
				pA += peoples[i];
			else
				pB += peoples[i];
		}
		int diff = Math.abs(pA - pB);
		res = Math.min(res, diff);
	}

}