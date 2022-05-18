import sys

N, M = map(int, sys.stdin.readline().split())

a = set(str(sys.stdin.readline().rstrip()) for _ in range(N))
b = set(str(sys.stdin.readline().rstrip()) for _ in range(M))
result = sorted(list(a&b))
print(len(result))
for i in result:print(i)