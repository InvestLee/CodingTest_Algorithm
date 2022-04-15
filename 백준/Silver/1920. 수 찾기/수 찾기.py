import sys

#반씩 나눠서 대소비교후 다시 영역 좁혀가는 이분법
def bf(arr, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return 1
        elif arr[mid] > target:
            end = mid-1
        else:
            start = mid+1
    return 0

N = int(sys.stdin.readline().rstrip())
Num = list(map(int, sys.stdin.readline().split()))
Num = sorted(Num)
M = int(sys.stdin.readline().rstrip())
Mum = list(map(int, sys.stdin.readline().split()))

for i in range(M):
    print(bf(Num,Mum[i],0,N-1))