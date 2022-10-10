#유니온파인드로 방문여부 확인 및 여행(순환하는 곳이 없는 트리의 특성 이용)

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

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    parent = [i for i in range(N+1)]
    result = 0
    for _ in range(M):
        a, b = map(int, sys.stdin.readline().split())
        if find_parent(a) != find_parent(b): #이미 가본 여행지는 횟수 세지 않음
            result += 1
        union_parent(a,b)
    print(result)