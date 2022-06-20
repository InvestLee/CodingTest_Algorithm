import sys

N = int(sys.stdin.readline().rstrip())
for i in range(N):
    print(" "*i+"*"*(2*(N-i)-1))