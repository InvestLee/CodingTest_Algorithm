import sys

V, E = map(int, sys.stdin.readline().split())
#자기 자신에서 자기 자신을 최댓값으로 설정하여 사이클 초기값 설정 
graph = [[int(1e9) for _ in range(V)] for _ in range(V)]
for _ in range(E):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a-1][b-1] = c

for k in range(V):#플로이드 워셜
    for i in range(V):
        for j in range(V):
            graph[i][j] = min(graph[i][j],graph[i][k]+graph[k][j])

result = int(1e9) #사이클인 경우 중 도로 최소 길이 도출
for i in range(V):
    result = min(result,graph[i][i])

if result == int(1e9):
    print(-1)
else:
    print(result)