import sys
from bisect import bisect_left

n = int(sys.stdin.readline().rstrip())
arr = [0] + list(map(int, sys.stdin.readline().split()))
lis = [-int(2e9)]
dp = [0] * (n+1)

for i in range(1,n+1):
    if lis[-1] < arr[i]:
        lis.append(arr[i])
        dp[i] = len(lis)-1
    else:
        dp[i] = bisect_left(lis,arr[i])
        lis[dp[i]] = arr[i]
print(len(lis)-1)

maxIndex, result = max(dp)+1, []
for i in range(n,0,-1):
    if dp[i] == maxIndex-1:
        result.append(arr[i])
        maxIndex = dp[i]
print(*result[::-1])