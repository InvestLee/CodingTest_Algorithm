from collections import deque

def solution(n, computers):
    #각 컴퓨터와 이어진 컴퓨터
    graph = [[] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1 and i != j : graph[i].append(j)
            
    #네트워크 방문하는 bfs
    visited = [False] * n
    def bfs(start):
        q = deque()
        q.append(start)
        visited[start] = True
        while q:
            next_node = q.popleft()
            for g in graph[next_node]:
                if visited[g] == False:
                    visited[g] = True
                    q.append(g)
    
    #각 네트워크 방문 횟수
    count = 0
    for i in range(n):
        if visited[i] == False:
            bfs(i)
            count += 1
    
    return count