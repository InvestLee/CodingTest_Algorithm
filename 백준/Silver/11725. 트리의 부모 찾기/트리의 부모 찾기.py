import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
tree = [[] for _ in range(N+1)]
parent_arr = [0 for _ in range(N+1)] #각 위치의 부모 노드
#각 노드간 연결
for i in range(N-1):
    a, b = map(int, sys.stdin.readline().split())
    tree[a].append(b)
    tree[b].append(a)


q = deque()
q.append(1) #1이 root이므로 1부터 시작
while q:
    parent = q.popleft() #자식을 찾기 위한 부모노드
    for t in tree[parent]: #부모노드와 이어진 자식들 조회
        if parent_arr[t] == 0: #앗 저희 부모님 모릅니다 혹시 당신이 저의 부모인가요?
            parent_arr[t] = parent #내가 너의 부모다 선언
            q.append(t) #손자 소개시켜드리기위한 추가

for i in range(2,N+1):
    print(parent_arr[i])