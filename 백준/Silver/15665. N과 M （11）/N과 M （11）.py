import sys

N, M = map(int, sys.stdin.readline().split())
num_arr = list(set(map(int, sys.stdin.readline().split())))
num_arr.sort()
print_num = []

def backtracking():
    if len(print_num) == M:
        print(*print_num)
        return
    for i in range(len(num_arr)):
        print_num.append(num_arr[i])
        backtracking()
        print_num.pop()

backtracking()