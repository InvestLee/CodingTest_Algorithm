import sys

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    arr = []
    N = int(sys.stdin.readline().rstrip())
    for i in range(N):
        a, b = map(str, sys.stdin.readline().split())
        arr.append(b)
    set_arr = list(set(arr))
    num = []
    for i in set_arr:
        num.append(arr.count(i))
    result = 1
    for i in num:
        result *= (i+1)
    print(result-1)