import sys
import itertools #sum보다 빠름 누적합

N, M = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))
result = list(itertools.accumulate(A)) #sum보다 빠름 누적합
for i in range(M):
    start, end = map(int, sys.stdin.readline().split())
    if start == 1:
        print(result[end-1])
    else:
        print(result[end-1]-result[start-2])