import sys

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())
graph = [[int(1e9) for _ in range(n)] for _ in range(n)]

for i in range(n): #자신한테 가는 비용은 0
    graph[i][i] = 0

for _ in range(m): #경로에 비용 대입
    start, end, cost = map(int, sys.stdin.readline().split())
    if graph[start-1][end-1] > cost:
        graph[start-1][end-1] = cost

for k in range(n): #플로이드 워셜(경로를 가장 앞에 배치)
    for a in range(n):
        for b in range(n):
            graph[a][b] = min(graph[a][b],graph[a][k]+graph[k][b])

for i in range(n):
    for j in range(n):
        if graph[i][j] == int(1e9):
            print(0,end=' ')
        else:
            print(graph[i][j],end=' ')
    print()