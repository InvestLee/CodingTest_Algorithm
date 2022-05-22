import sys

N, W, H = map(int, sys.stdin.readline().split())
length = (W**2+H**2)**(1/2)

for _ in range(N):
    P = int(sys.stdin.readline().rstrip())
    if P<=length:
        print("DA")
    else:
        print("NE")