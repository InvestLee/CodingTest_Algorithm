import sys

N, M = map(int, sys.stdin.readline().split())
N_list = set([])
M_list = []
for i in range(N):
    N_list.add(str(sys.stdin.readline().rstrip()))

for i in range(M):
    M_list.append(str(sys.stdin.readline().rstrip()))

count = 0
for i in M_list:
    if i in N_list:
        count += 1
print(count)