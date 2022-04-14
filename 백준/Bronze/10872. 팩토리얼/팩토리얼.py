import sys

def facto(N):
    result = 1
    if N > 0:
        result = N * facto(N-1)
    return result

N = int(sys.stdin.readline().rstrip())
print(facto(N))