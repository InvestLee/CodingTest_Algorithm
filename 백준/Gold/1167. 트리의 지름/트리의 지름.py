import sys
sys.setrecursionlimit(int(1e9))

n = int(sys.stdin.readline().rstrip())
tree = [[] for _ in range(n+1)]
max_len = 0 #가장 연결된 노드가 많은 노드의 길이
max_len_index = 0 #가장 연결된 노드가 많은 노드
for i in range(n):
    input_list = list(map(int, sys.stdin.readline().split()))
    if max_len < len(input_list):
        max_len = len(input_list)
        max_len_index = i+1
    for j in range(1,len(input_list),2):
        if input_list[j] == -1:
            break
        else:
            tree[input_list[0]].append((input_list[j],input_list[j+1]))

#현재 노드에서 가장 먼 노드를 찾기 위해 각 노드의 거리 계산
def dfs(node,dist):
    for next_node, next_dist in tree[node]:
        if Distance[next_node] == -1:
            Distance[next_node] = dist+next_dist
            dfs(next_node,dist+next_dist)

#가장 연결된 노드가 많은 노드에서 가장 먼 노드 찾기
Distance = [-1] * (n+1)
Distance[max_len_index] = 0 #자신은 포함하지 않기 위해
dfs(max_len_index,0)
far_node = Distance.index(max(Distance))

#트리의 지름 출력
Distance = [-1] * (n+1)
Distance[far_node] = 0
dfs(far_node,0)
print(max(Distance))