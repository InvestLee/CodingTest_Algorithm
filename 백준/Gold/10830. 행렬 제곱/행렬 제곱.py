import sys
sys.setrecursionlimit(int(1e9))

#입력
N, B = map(int,sys.stdin.readline().split())
A = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]

#행렬의 곱셈
def multi_A(A1,A2,N):
    cal_result = [[0]*N for _ in range(N)]
    for i in range(N):        
        for j in range(N):
            for k in range(N):
                cal_result[i][j] += (A1[i][k]*A2[k][j])
            cal_result[i][j] %= 1000
    return cal_result

#행렬의 거듭 제곱
def division_conquest(N,B,A):
    if B == 1:
        return A
    C = division_conquest(N,B//2,A)
    if B % 2:
        return multi_A(multi_A(C,C,N),A,N)
    else:
        return multi_A(C,C,N)

#출력
result = division_conquest(N,B,A)
for res in result:
    for r in res:
        print(r%1000,end=" ")
    print()