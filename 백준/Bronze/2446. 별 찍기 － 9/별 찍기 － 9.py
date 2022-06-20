import sys

N = int(sys.stdin.readline().rstrip())
for i in range(N):
    print(" "*i+"*"*(2*(N-i)-1))
for i in range(1,N):
    print(" "*(N-i-1)+"*"*(2*i+1))