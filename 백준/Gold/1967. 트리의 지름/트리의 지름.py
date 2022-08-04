import sys
sys.setrecursionlimit(int(1e9))

n = int(sys.stdin.readline().rstrip())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b, c = map(int, sys.stdin.readline().split())
    tree[a].append((b,c))
    tree[b].append((a,c))

#현재 노드에서 가장 먼 노드를 찾기 위해 각 노드의 거리 계산
def dfs(node,dist):
    for next_node, next_dist in tree[node]:
        if Distance[next_node] == -1:
            Distance[next_node] = dist+next_dist
            dfs(next_node,dist+next_dist)

#root노드에서 가장 먼 노드 찾기
Distance = [-1] * (n+1)
Distance[1] = 0 #자신은 포함하지 않기 위해
dfs(1,0)
far_node = Distance.index(max(Distance))

#트리의 지름 출력
Distance = [-1] * (n+1)
Distance[far_node] = 0
dfs(far_node,0)
print(max(Distance))