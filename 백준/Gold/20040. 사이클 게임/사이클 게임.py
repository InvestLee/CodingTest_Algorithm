import sys
sys.setrecursionlimit(int(1e9))

#사이클이 이루어지는 경우는 같은 조상을 가진 점들이 연결되었을 경우 사이클 생성
n, m = map(int,sys.stdin.readline().split())
make_line = [list(map(int,sys.stdin.readline().split())) for _ in range(m)]
#각 점들의 조상
arr = [i for i in range(n)]

#조상 찾기
def find_parent(arr,a):
    if arr[a] != a:
        arr[a] = find_parent(arr,arr[a])
    return arr[a]

#합집합
def union_parent(arr,a,b,i):
    global result
    a = find_parent(arr,arr[a])
    b = find_parent(arr,arr[b])
    if a < b:
        arr[b] = a
    elif a > b:
        arr[a] = b
    #같은 조상을 가진 점들이 연결되었을 경우 사이클로 판별
    elif result == 0:
        result = i+1

result = 0
for i in range(m):
    union_parent(arr,make_line[i][0],make_line[i][1],i)

print(result)