import sys

memo = [0] * 101 #메모이제이션
memo[1:11] = [1,1,1,2,2,3,4,5,7,9]
for i in range(11,101):
    memo[i] = memo[i-1]+memo[i-5] #문제에서 요구하는 계산

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    print(memo[N])