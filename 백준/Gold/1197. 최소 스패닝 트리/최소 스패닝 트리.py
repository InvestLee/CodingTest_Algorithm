#크루스칼 알고리즘, Union_find 알고리즘

import sys
import heapq

V, E = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(E)]
graph.sort(key= lambda x:x[2]) #가중치 순으로 정렬(크루스칼 알고리즘 전제 조건)
parent = [i for i in range(V+1)] #인덱스 1에는 1 위치 맞춰주기 위해 범위 이렇게 설정
result = 0

#조상 찾기(이미 검토된 루트 패스)
def find_parent(a):
    if parent[a] != a:
        parent[a] = find_parent(parent[a])
    return parent[a]

#합집합(방문 처리)
def union_parent(a,b):
    a = find_parent(parent[a])
    b = find_parent(parent[b])
    if a < b:
        parent[b] = a
    elif a > b:
        parent[a] = b

for a, b, c in graph:
    #만약 가지 않았던 루트라면(서로 부모가 다른 경우)
    if find_parent(a) != find_parent(b):
        #방문 처리(부모 동일하게)
        union_parent(a,b)
        result += c

print(result)