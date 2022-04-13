import sys

N = int(sys.stdin.readline().rstrip())
Three = 0

#큰걸로 안될떄 작은걸로 한번 뺴고 다시 검토하는 그리디 전략

while True:
    if N%5 != 0:
        N -= 3
        Three += 1
    elif N < 0:
        print(-1)
        break
    else:
        print(N//5+Three)
        break