#모든 위치를 구해야하므로 플로이드 워셜
import sys

n, m, r = map(int, sys.stdin.readline().split())
item = list(map(int, sys.stdin.readline().split()))
graph = [[int(1e9)] * (n+1) for _ in range(n+1)]

#자기 자신한테 가는 거리는 0
for i in range(n+1):
    graph[i][i] = 0

#양방향 통행
for _ in range(r):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a][b] = c
    graph[b][a] = c

#플로이드 워셜
for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

#아이템 수 환산
result = 0
for i in range(1,n+1):
    result_i = 0 #i위치로 배치받을 시 아이템 수
    for j in range(1,n+1):
        if graph[i][j] <= m: #수색거리 내
            result_i += item[j-1]
    result = max(result,result_i)

print(result)