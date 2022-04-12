import sys

N = int(sys.stdin.readline().rstrip())
A = int(sys.stdin.readline().rstrip())
Sum = 0
for i in str(A):
    Sum += int(i)
print(Sum)