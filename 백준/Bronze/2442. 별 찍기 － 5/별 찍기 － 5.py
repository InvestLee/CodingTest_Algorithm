import sys

N = int(sys.stdin.readline().rstrip())
for i in range(N):
    print(" "*(N-i-1)+"*"*(2*i+1))