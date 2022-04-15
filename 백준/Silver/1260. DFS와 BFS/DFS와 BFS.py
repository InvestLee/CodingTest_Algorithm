from collections import deque
import sys

N, M, V = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
for i in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graph[A].append(B) #연결되는 노드 서로 넣기
    graph[B].append(A)

for i in range(1, N+1):
    graph[i] = sorted(graph[i]) #번호 적은 것부터 방문

visited = [False] * (N+1) #방문여부

def dfs(graph, V, visited):
    visited[V] = True
    print(V, end=' ')
    for i in graph[V]:
        if not visited[i]:
            dfs(graph, i, visited)

def bfs(graph, V, visited):
    queue = deque([V])
    visited[V] = True
    while queue:
        V = queue.popleft()
        print(V, end=' ')
        for i in graph[V]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

dfs(graph, V, visited)
visited = [False] * (N+1) #방문여부 초기화
print() #줄바꿈
bfs(graph, V, visited)