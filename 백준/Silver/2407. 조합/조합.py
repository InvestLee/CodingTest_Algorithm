import sys

N, M = map(int, sys.stdin.readline().split())
result = 1
for i in range(M):
    result *= (N-i)
    result //= i+1

print(result)