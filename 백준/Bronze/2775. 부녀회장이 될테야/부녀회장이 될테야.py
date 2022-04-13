import sys

T = int(sys.stdin.readline().rstrip())

#n*(n+1)*.........*(n+k) / 1*2*......*(k+1)

for i in range(T):
    k = int(sys.stdin.readline().rstrip())
    n = int(sys.stdin.readline().rstrip())
    C = 1 #결과값
    for j in range(k+1):
        C = C*(n+j)/(j+1)
    print(int(C))