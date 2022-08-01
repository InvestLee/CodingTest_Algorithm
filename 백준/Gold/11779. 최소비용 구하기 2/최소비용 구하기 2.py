import sys
import heapq

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append([b,c])
start, end = map(int, sys.stdin.readline().split())

#다익스트라
def dijkstra(start):
    visited = [[int(1e9),[]] for _ in range(n+1)]
    q = []
    heapq.heappush(q,(start,0))
    visited[start][0] = 0
    #경로 저장
    visited[start][1].append(start)
    while q:
        now, cost = heapq.heappop(q)
        if cost > visited[now][0]:
            continue
        for i in graph[now]:
            fee = cost+i[1]
            if fee < visited[i[0]][0]:
                visited[i[0]][0] = fee
                #경로 대입
                visited[i[0]][1] = [v for v in visited[now][1]]
                #경로 저장
                visited[i[0]][1].append(i[0])
                heapq.heappush(q,(i[0],fee))
    return visited

result = dijkstra(start)
print(result[end][0])
print(len(result[end][1]))
print(' '.join(map(str, result[end][1])))