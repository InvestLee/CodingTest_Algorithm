import sys
sys.setrecursionlimit(int(1e9))

N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
graph = [list(map(int, sys.stdin.readline().split())) for i in range(N)]
arr = [i for i in range(N)]
plan = list(map(int, sys.stdin.readline().split()))

#root 찾기
def find_parent(arr,a):
    if arr[a] != a:
        p = find_parent(arr,arr[a])
        arr[a] = p
        return arr[a]
    return a

#a와 b를 합하기
def union_parent(arr,a,b):
    a = find_parent(arr,a)
    b = find_parent(arr,b)
    if a < b:
        arr[b] = a
    else:
        arr[a] = b

#합집합 만들기
for i in range(N):
    for j in range(i+1,N):
        if graph[i][j] == 1:
            union_parent(arr,i,j)

#여행 경로 가능 여부
for i in range(1,len(plan)):
    if find_parent(arr,plan[i-1]-1) != find_parent(arr,plan[i]-1):
        print("NO")
        break
else:
    print("YES")