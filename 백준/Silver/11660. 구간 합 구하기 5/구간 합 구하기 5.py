import sys

N, M = map(int, sys.stdin.readline().split())
graph = [[0]*(N+1)]+[[0]+list(map(int, sys.stdin.readline().split())) for _ in range(N)]

#누적합 행
for i in range(1,N+1):
    for j in range(2,N+1):
        graph[i][j] += graph[i][j-1]

#누적합 열
for i in range(2,N+1):
    for j in range(1,N+1):
        graph[i][j] += graph[i-1][j]

#정해진 영역까지의 합에서 열 부분으로 벗어나는 부분과 행 부분으로 벗어나는 부분을 빼주고
#벗어나는 부분끼리 겹치는 부분을 다시 더해준다.
for _ in range(M):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    print(graph[x2][y2]-graph[x1-1][y2]-graph[x2][y1-1]+graph[x1-1][y1-1])