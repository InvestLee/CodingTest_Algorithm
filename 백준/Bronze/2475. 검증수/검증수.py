import sys

A = list(map(int, sys.stdin.readline().split()))
result = 0
for i in A:
    result += i**2
print(result % 10)