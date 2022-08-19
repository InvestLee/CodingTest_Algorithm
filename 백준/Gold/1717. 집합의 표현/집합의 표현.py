import sys
sys.setrecursionlimit(int(1e9))

n, m = map(int, sys.stdin.readline().split())
command_arr = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
arr = [i for i in range(n+1)]

#부모 찾기
def find_parent(arr, x):
    if arr[x] != x: 
        p = find_parent(arr, arr[x])
        arr[x] = p
        return arr[x]
    return x

#합집합
def union_parent(arr, a, b):
    a = find_parent(arr, a)
    b = find_parent(arr, b)
    if a < b:
        arr[b] = a
    else:
        arr[a] = b

for num, a, b in command_arr:
    if num == 0: 
        union_parent(arr, a, b)
    else:
        #같은 부모를 가진다면 합집합    
        if find_parent(arr, a) == find_parent(arr, b):
            print("YES")
        else:
            print("NO")
