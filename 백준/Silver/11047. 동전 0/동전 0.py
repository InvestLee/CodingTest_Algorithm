import sys

N, K = map(int, sys.stdin.readline().split())
D = [0]*N
for i in range(N):
    D[i] = int(sys.stdin.readline().rstrip())
count = 0
j = N-1

while K > 0:
    if j < -1:
        break
    if D[j] > K:
        j -= 1
    else:
        K -= D[j]
        count += 1

print(count)