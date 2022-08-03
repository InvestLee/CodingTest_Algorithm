import sys

def bf(): #이 문제는 음의 간선 사이클이 존재 여부 확인을 묻는 문제
    for i in range(N): #N-1번 반복
        for j in range(len(route)): #모든 도로와 웜홀 확인
            now, next_node, cost = route[j]
            #현재 간선을 거치는 경우가 다른 노드로 이동하는 경우보다 짧은 경우
            if Distance[next_node] > Distance[now]+cost:
                Distance[next_node] = Distance[now]+cost
                if i == N-1:
                    return True
    return False

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N, M, W = map(int, sys.stdin.readline().split())
    route = []
    Distance = [int(1e9) for _ in range(N+1)]
    for _ in range(M):
        S, E, T = map(int, sys.stdin.readline().split())
        route.append((S,E,T))
        route.append((E,S,T))
    for _ in range(W):
        S, E, T = map(int, sys.stdin.readline().split())
        route.append((S,E,-T))
    
    if bf():
        print("YES")
    else:
        print("NO")