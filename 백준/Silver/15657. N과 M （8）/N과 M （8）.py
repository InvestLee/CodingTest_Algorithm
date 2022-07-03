import sys

N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()
print_node = []

#백트래킹
#start지점을 통해 자신보다 더 작은 노드를 고려하지 않게 설계
def backtracking(start,count):
    if count == M:
        print(' '.join(map(str, print_node)))
        return
    for i in range(start,N):
        print_node.append(arr[i])
        backtracking(i,count+1)
        print_node.pop()

backtracking(0,0)