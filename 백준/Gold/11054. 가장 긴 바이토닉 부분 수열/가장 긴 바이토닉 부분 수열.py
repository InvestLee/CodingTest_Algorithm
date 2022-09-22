import sys
from bisect import bisect_left

N = int(sys.stdin.readline().rstrip())
A = list(map(int,sys.stdin.readline().split()))
result = 0

#각 기준 별로 시행
for i in range(N):
    Lis_arr = [0]
    temp_result = 0
    left_A = A[:i+1] #기준점에서 좌측
    right_A = A[i+1:] #기준점에서 우측(기준점을 포함하지 않는 이유는 조건으로 활용하기 때문)
    right_A = right_A[::-1] #LIS조건을 위해 배열 뒤집기
    #좌측 배열 LIS 시행
    for l in left_A:
        if l > Lis_arr[-1]:
            Lis_arr.append(l)
        else:
            Lis_arr[bisect_left(Lis_arr,l)] = l
    temp_result += len(Lis_arr)-1
    
    #기준점보다 작아야 되므로 r < A[i] 조건 추가하여 우측 배열 LIS 시행
    Lis_arr = [0]
    for r in right_A:
        if r > Lis_arr[-1] and r < A[i]:
            Lis_arr.append(r)
        elif r < A[i]:
            Lis_arr[bisect_left(Lis_arr,r)] = r
    temp_result += len(Lis_arr)-1
    #최댓값 갱신
    result = max(result,temp_result)

print(result)