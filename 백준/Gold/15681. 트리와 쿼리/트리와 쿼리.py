import sys
sys.setrecursionlimit(int(1e9))

N, R, Q = map(int, sys.stdin.readline().split())
connect = [[] for _ in range(N+1)]

for _ in range(N-1):
    a, b = map(int, sys.stdin.readline().split())
    connect[a].append(b)
    connect[b].append(a)

sub_tree = [0] * (N+1) #dfs로 서브트리 갯수 기록
visited = [False] * (N+1) #해당 정점 방문처리

def dfs(node):
    sub_tree[node] = 1 #자기 자신도 포함
    visited[node] = True
    for i in connect[node]: #node와 연결된 정점들 중에서 아직 방문되지 않은 것은 자식 노드
        if not visited[i]: 
            dfs(i) #역산을 위한 Backtracking
            sub_tree[node] += sub_tree[i]

dfs(R) #root노드를 기준으로 dfs처리

for _ in range(Q):
    print(sub_tree[int(sys.stdin.readline().rstrip())])