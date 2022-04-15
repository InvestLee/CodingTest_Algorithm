import sys

def bfs(graph, v, visited, route): #저장을 위한 route
    visited[v] = True
    route.append(v) #출력말고 저장
    for i in graph[v]:
        if not visited[i]:
            bfs(graph, i, visited, route)

N = int(sys.stdin.readline().rstrip())
L = int(sys.stdin.readline().rstrip())
visited = [False]*(N+1)
graph = [[] for i in range(N+1)]
for i in range(1, L+1):
    A, B = map(int, sys.stdin.readline().split())
    graph[A].append(B)
    graph[B].append(A)
route = []
#for i in range(1,N+1):
#    graph[i] = sorted(graph[i])

bfs(graph, 1, visited, route)
print(len(route)-1) #자기자신 제외