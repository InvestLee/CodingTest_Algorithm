import sys
from copy import deepcopy
from itertools import permutations

N, M, K = map(int, sys.stdin.readline().split())
A = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
rotate_A = []
for _ in range(K):
    r, c, s = map(int, sys.stdin.readline().split())
    rotate_A.append([r-1,c-1,s])
copy_A = deepcopy(A)

#배열 회전 함수
def rotate_method(r,c,s):
    for i in range(s,0,-1):
        temp_value = copy_A[r-i][c+i]
        #우측 이동
        copy_A[r-i][c-i+1:c+i+1] = copy_A[r-i][c-i:c+i]
        #상측 이동
        for row in range(r-i, r+i):
            copy_A[row][c-i] = copy_A[row+1][c-i]
        #좌측 이동
        copy_A[r+i][c-i:c+i] = copy_A[r+i][c-i+1:c+i+1]
        #하측 이동
        for row in range(r+i, r-i,-1):
            copy_A[row][c+i] = copy_A[row-1][c+i]
        copy_A[r-i+1][c+i] = temp_value

#행의 최소값 산출 함수
def min_sum(copy_A):
    min_result = int(1e9)
    for c in copy_A:
        min_result = min(min_result,sum(c))
    return min_result

#배열을 회전시키는 수
back_list = [i for i in range(K)]
back_list = list(permutations(back_list))
result = int(1e9)

#각 경우 행의 최솟값 찾기
for b in back_list:
    copy_A = deepcopy(A)
    for order in b:
        r, c, s = rotate_A[order]
        rotate_method(r,c,s)
    result = min(result,min_sum(copy_A))
print(result)