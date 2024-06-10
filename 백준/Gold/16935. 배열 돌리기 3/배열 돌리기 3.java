import java.util.*;
import java.io.*;

public class Main {
    
	static int N, M, R;
	static int[][] arr;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N][M];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<R; i++) {
    		int o = Integer.parseInt(st.nextToken());
    		
    		rotate(o);
    	}
    	
    	print();
    }


    static void rotate(int order) {
    	switch(order) {
	    	case 1: rotateOne();
	    		break;
	    	case 2: rotateTwo();
	    		break;
	    	case 3: rotateThree();
	    		break;
	    	case 4: rotateFour();
	    		break;
	    	case 5: rotateFive();
	    		break;
	    	case 6: rotateSix();
	    		break;
    	}
    }
    
    static void rotateOne() {
    	for(int j=0; j<M; j++) {
    		for(int i=0; i<N/2; i++) {
    			int temp = arr[i][j];
    			arr[i][j] = arr[N-i-1][j];
    			arr[N-i-1][j] = temp;
    		}
    	}
    }
    
    static void rotateTwo() {
    	for(int i=0; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M-j-1];
				arr[i][M-j-1] = temp;
			}
		}
    }
    
    static void rotateThree() {
    	Queue<Integer> que = new LinkedList<>();
    	
    	int newILen = M;
    	int newJLen = N;
    	
    	int[][] copy = new int[newILen][newJLen];
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			que.add(arr[i][j]);
    		}
    	}
    	
    	for(int j=N-1; j>=0; j--) {
    		for(int i=0; i<M; i++) {
    			copy[i][j] = que.poll();
    		}
    	}
    	
    	N = newILen;
    	M = newJLen;
    	
    	arr = new int[N][M];
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			arr[i][j] = copy[i][j];
    		}
    	}
    }
    
    static void rotateFour() {
    	Queue<Integer> que = new LinkedList<>();
    	
    	int newILen = M;
    	int newJLen = N;
    	
    	int[][] copy = new int[newILen][newJLen];
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			que.add(arr[i][j]);
    		}
    	}
    	
    	for(int j=0; j<N; j++) {
    		for(int i=M-1; i>=0; i--) {
    			copy[i][j] = que.poll();
    		}
    	}
    	
    	
    	N = newILen;
    	M = newJLen;
    	
    	arr = new int[N][M];
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			arr[i][j] = copy[i][j];
    		}
    	}
    	
    }
    
    static void rotateFive() {
    	int[][] copy = new int[N][M];
		int n = N/2;
		int m = M/2;
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j+m] = arr[i][j];
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i+n][j+m] = arr[i][j+m];
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i+n][j] = arr[i+n][j+m];
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = arr[i+n][j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = copy[i][j];
			}
		}
    }
    
    static void rotateSix() {
    	int[][] copy = new int[N][M];
		int n = N/2;
		int m = M/2;
    	
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i+n][j+m] = arr[i+n][j];
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j+m] = arr[i+n][j+m];
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i+n][j] = arr[i][j];
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = arr[i][j+m];
			}
		}
    	
    	for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = copy[i][j];
			}
		}
    }
    
    static void print() {
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			System.out.print(arr[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
}