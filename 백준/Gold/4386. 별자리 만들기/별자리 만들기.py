import sys
sys.setrecursionlimit(int(1e9))

n = int(sys.stdin.readline().rstrip())
star_list = [list(map(float, sys.stdin.readline().split())) for _ in range(n)]

#i번째 별과 j번쨰 별의 거리
star_Distance = []
for i in range(n-1):
    for j in range(i+1,n):
        Distance_i_j = ((star_list[i][0]-star_list[j][0])**2+(star_list[i][1]-star_list[j][1])**2)**(1/2)
        star_Distance.append((Distance_i_j, i, j))
star_Distance.sort() #최소거리 순으로 정렬

#유니온 파인드
parent = [i for i in range(n)]

def find_parent(a):
    if parent[a] != a:
        parent[a] = find_parent(parent[a])
    return parent[a]

def union_parent(a,b):
    a = find_parent(a)
    b = find_parent(b)
    if a > b:
        parent[a] = b
    else:
        parent[b] = a

#유니온 파인드를 통해 이미 연결된 점들은 무시
result = 0
for cost, s1, s2 in star_Distance:
    if find_parent(s1) != find_parent(s2):
        union_parent(s1,s2)
        result += cost

print(round(result,2))