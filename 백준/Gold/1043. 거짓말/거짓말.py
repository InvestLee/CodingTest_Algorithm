import sys

N, M = map(int, sys.stdin.readline().split())
true_know = set(list(map(int, sys.stdin.readline().split()))[1:]) #진실을 아는 사람을 효율적으로 탐색
parties = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]
parent = [i for i in range(N+1)] #유니온 파인드를 통해 진실 공유자 색출

def find_parent(a):
    if parent[a] != a:
        parent[a] = find_parent(parent[a])
    return parent[a]

#거짓말 아는 애들을 위주로 합
def union_parent(a,b):
    a = find_parent(a)
    b = find_parent(b)
    if b in true_know:
        parent[a] = b
    elif a in true_know:
        parent[b] = a
    elif a > b:
        parent[a] = b
    else:
        parent[b] = a

#진실 공유자 색출 작업
for i in range(len(parties)):
    if len(parties[i]) > 2:
        for j in range(2,len(parties[i])):
            union_parent(parties[i][j-1],parties[i][j])

#진실의 조상노드 찾기
for p in parent:
    find_parent(p)

#과장할 수 있는 파티 계산
result = 0
for party in parties:
    for i in range(1,len(party)):
        if find_parent(party[i]) in true_know:
            break
    else:
        result += 1

print(result)