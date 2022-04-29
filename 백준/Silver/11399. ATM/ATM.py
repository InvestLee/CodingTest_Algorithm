import sys
import itertools

N = int(sys.stdin.readline().rstrip())
arr = list(map(int,sys.stdin.readline().split()))
arr = sorted(arr)
arr = list(itertools.accumulate(arr))
print(sum(arr))