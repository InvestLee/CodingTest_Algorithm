import sys
from collections import deque

def bfs(graph, start, visited):
    count = 1
    queue = deque([start])
    visited[start] = count
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                count += 1
                queue.append(i)
                visited[i] = count
                
N, M, R = map(int, sys.stdin.readline().split())
visited = [0] * (N+1)
graph = [[] for _ in range(N+1)]
for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

bfs(graph, R, visited)

for i in range(1,N+1):
    print(visited[i])
