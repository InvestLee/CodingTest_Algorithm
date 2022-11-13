import sys
from bisect import bisect_left

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().split()))
lis = [0]

for a in arr:
    if lis[-1] < a:
        lis.append(a)
    else:
        lis[bisect_left(lis,a)] = a

print(len(lis)-1)