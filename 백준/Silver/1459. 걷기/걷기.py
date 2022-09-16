import sys

X, Y, W, S = map(int, sys.stdin.readline().split())
X, Y = max(X,Y), min(X,Y)
print(min((X+Y)*W, Y*S + (X-Y)*W, Y*S + (X-Y)//2*2*S + (X-Y)%2*W))

#가로 세로 가는 경우보다 대각선으로 가는 경우가 효율적인 경우
#대각으로 가는 경우보다 가로 세로로 가는 경우가 효율적인 경우
#대각선으로 가는 경우가 한칸 이동하는 경우보다 짧은 경우