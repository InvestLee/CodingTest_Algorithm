#투 포인터, 부분합

import sys
from itertools import accumulate
N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
arr = list(accumulate(arr)) #누적합

#누적합에서 최소 부분 찾기
result = sys.maxsize
for i in range(N):
    if arr[i] >= S:
        result = i+1
        break

left = 0 #좌측 탐색
right = 1 #우측 탐색
while right < N:
    tmp_num = arr[right]-arr[left] #부분합
    if S > tmp_num:
        right += 1
    else: #S 이상
        result = min(result,right-left)
        left += 1

if result == sys.maxsize : result = 0
print(result)