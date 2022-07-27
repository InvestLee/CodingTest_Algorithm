from collections import deque

def solution(n, wires):
    #연결된 송전탑 수 계산을 위한 bfs
    def bfs(start):
        q = deque()
        q.append(start)
        visited[start] = True
        count = 1
        while q:
            next_node = q.popleft()
            for g in graph[next_node]:
                if visited[g] == False:
                    visited[g] = True
                    q.append(g)
                    count += 1
        return count
    
    answer = 101
    for i in range(len(wires)):
        graph = [[] for _ in range(n+1)]
        for j in range(len(wires)):
            if i == j: #선택한 부분 연결 끊기
                continue
            graph[wires[j][0]].append(wires[j][1])
            graph[wires[j][1]].append(wires[j][0])
        
        visited = [False] * (n+1)
        count_network = []
        for j in range(1,n+1):
            if visited[j] == False:
                count_network.append(bfs(j))        
        #송전탑 개수 차이 최소값
        answer = min(answer,abs(count_network[0]-count_network[1])) 
    return answer