import sys
N = int(sys.stdin.readline().rstrip())

for i in range(1, N+1):
    bun = sum(map(int, str(i))) #각 한자리 수들을 다 더함
    veri = i+bun #추정값과 추정값을 분해한 수들의 합
    if veri == N: #
        print(i)
        break
    if i == N:
        print(0)