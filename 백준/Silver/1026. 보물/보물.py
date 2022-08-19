import sys

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))
A.sort()
B.sort(reverse=True)
result = 0
for i in range(N):
    result += (A[i]*B[i])
print(result)