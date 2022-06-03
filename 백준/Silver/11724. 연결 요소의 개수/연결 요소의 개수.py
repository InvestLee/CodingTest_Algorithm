import sys
from collections import deque

def bfs(n):
    queue = deque([])
    queue.append(n)
    visited[n] = True
    connect_true = False #한번이라도 연결되었으면 True
    while queue: #시작점과 직접적 간접적으로 연결된 모든 노드
        q = queue.popleft()
        for g in graph[q]:
            if visited[g] == False:
                queue.append(g)
                visited[g] = True
                connect_true = True

N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)
for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

result = 0
for i in range(1,N+1):
    if visited[i] == False: #방문처리가 안되어있는 횟수 = 연결 요소 갯수
        bfs(i)
        result += 1
print(result)