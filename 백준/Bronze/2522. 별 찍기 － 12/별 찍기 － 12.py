import sys

N = int(sys.stdin.readline().rstrip())
for i in range(N):
    print(" "*(N-i-1)+"*"*(i+1))
for i in range(1,N):
    print(" "*i+"*"*(N-i))