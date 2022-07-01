import sys

N, M = map(int, sys.stdin.readline().split())
num_arr = list(map(int, sys.stdin.readline().split()))
#수열을 사전 순으로 증가하는 순서로 출력
num_arr.sort()
print_out = []

def backtracking(start):
    if len(print_out) == M:
        print(*print_out)
        return
    for i in range(start,N):
        print_out.append(num_arr[i])
        #현재 입력한 노드보다 더 큰 노드를 출력하기 위함
        backtracking(i+1)
        print_out.pop()

backtracking(0)