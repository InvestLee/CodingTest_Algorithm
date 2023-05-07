import sys

N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()
print_node = []

#백트래킹
def backtracking():
    if len(print_node) == M:
        print(' '.join(map(str, print_node)))
        return
    for i in range(N):
        print_node.append(arr[i])
        backtracking()
        print_node.pop()

backtracking()