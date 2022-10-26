#피보나치 수 행렬
#(Fn+2) = (1 1)(Fn+1) 즉 (1 1)의 n제곱으로 정의 가능
#(Fn+1)   (1 0)(F   )    (1 0)

import sys
sys.setrecursionlimit(int(1e9))

n = int(sys.stdin.readline().rstrip())
matrix = [[1,1],[1,0]] #행렬
fibo = [[1],[1]] #F1, F2
mod_num = 1000000007

#행렬의 곱
def multi(m1,m2):
    global mod_num
    multi_result = [[0] * len(m2[0]) for _ in range(len(m1))]
    for i in range(len(m1)):
        for j in range(len(m2[0])):
            for k in range(len(m1[0])):
                multi_result[i][j] += (m1[i][k] * m2[k][j]) % mod_num
    return multi_result

#제곱
def power_matrix(matrix,n):
    if n == 1: return matrix
    elif n%2: return multi(power_matrix(matrix,n-1),matrix) #n이 홀수일때
    else: return power_matrix(multi(matrix,matrix),n//2) #n이 짝수일떄

if n <= 2: print(1)
else: print(multi(power_matrix(matrix,n-2),fibo)[0][0] % mod_num)