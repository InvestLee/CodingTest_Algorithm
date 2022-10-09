#유니온파인드로 각 트리의 루트 노드를 찾은 후 중복을 제거하여 갯수 환산
#해당 두 노드의 조상이 같으면 사이클이 발생

import sys
sys.setrecursionlimit(int(1e9))

def find_parent(a):
    if parent[a] != a:
        parent[a] = find_parent(parent[a])
    return parent[a]

def union_parent(a,b):
    a = find_parent(parent[a])
    b = find_parent(parent[b])
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

cnt = 1 #루프 횟수
while True:
    n, m = map(int, sys.stdin.readline().split())
    if n == 0 and m == 0:
        break

    parent = [i for i in range(n+1)] #각 노드의 루트 노드
    cycle = [] #사이클이 일어난 노드
    for _ in range(m):
        a, b = map(int, sys.stdin.readline().split())
        if find_parent(a) == find_parent(b): #사이클 여부 판별
            cycle.append(a) #사이클 노드 추가
        union_parent(a,b) #간선 연결
    
    #각 노드의 루트 노드 갱신
    for i in range(n+1): 
        find_parent(i)

    #사이클이 일어난 노드의 루트 노드 집합
    cycle_root = set()
    for c in cycle:
        cycle_root.add(parent[c])
    
    parent = set(parent) #그래프와 트리의 수 + 1
    #그래프와 트리의 수 + 1 - 사이클이 일어난 루트노드 수 = 트리의 수 + 1
    if len(parent)-len(cycle_root) == 1:
        print("Case %d: No trees." % (cnt))
    elif len(parent)-len(cycle_root) == 2:
        print("Case %d: There is one tree." % (cnt))
    else:
        print("Case %d: A forest of %d trees." % (cnt,len(parent)-len(cycle_root) - 1))

    cnt += 1 #루프 횟수 상승