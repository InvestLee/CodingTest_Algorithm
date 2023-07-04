import sys

N, M = map(int, sys.stdin.readline().split())
num_arr = list(map(int, sys.stdin.readline().split()))
num_arr.sort()
print_num = []

def backtracking(start):
    if len(print_num) == M:
        print(*print_num)
        return
    remember = 0
    for i in range(start,len(num_arr)):
        if remember != num_arr[i]:
            print_num.append(num_arr[i])
            remember = num_arr[i]
            backtracking(i+1)
            print_num.pop()

backtracking(0)