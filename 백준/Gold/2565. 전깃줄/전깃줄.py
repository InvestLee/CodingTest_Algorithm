import sys
from bisect import bisect_left

N = int(sys.stdin.readline().rstrip())
electric_line = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

#전깃줄들이 안꼬이게 특정 전깃줄을 최소 갯수로 제거할려면 가장 긴 증가하는 수열 기법 사용
#A를 기준으로 정렬 후 B에 LIS기법 시행
electric_line.sort(key= lambda x:x[0])
#LIS 리스트
result_arr = [0]

for A, B in electric_line:
    if result_arr[-1] < B:
        result_arr.append(B)
    else:
        result_arr[bisect_left(result_arr,B)] = B

print(len(electric_line)-len(result_arr)+1)