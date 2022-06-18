import sys

N = int(sys.stdin.readline().rstrip())
graph = []
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))

#플로이드-워셜 알고리즘(바로 가는 경로 및 한번 경유해서 가는 경로 둘 중 하나 존재하는 경우)
for i in range(N):
    for j in range(N):
        for k in range(N):
            if graph[j][k] == 1 or (graph[j][i] == 1 and graph[i][k] == 1):
                graph[j][k] = 1

for g in graph:
    for num_g in g:
        print(num_g,end=" ")
    print()
