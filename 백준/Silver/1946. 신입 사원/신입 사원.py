import sys

t = int(sys.stdin.readline().rstrip())
for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    candidate = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    candidate.sort()
    rank_min = candidate[0][1]
    result = 1
    for i in range(n):
        if candidate[i][1] < rank_min:
            result += 1
            rank_min = candidate[i][1]
    print(result)