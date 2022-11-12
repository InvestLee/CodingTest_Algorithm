import sys

n = int(sys.stdin.readline().rstrip())
parent = list(map(int, sys.stdin.readline().split()))
delete_node = int(sys.stdin.readline().rstrip())

def dfs(del_node):
    parent[del_node] = -2 #-1은 루트노드 -2는 삭제노드로 지정    
    for i in range(len(parent)):
        if del_node == parent[i]:
            dfs(i)
dfs(delete_node)

result = 0
for i in range(n):
    if parent[i] != -2 and i not in parent:
        result += 1
print(result)