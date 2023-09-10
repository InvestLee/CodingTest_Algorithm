#15624 피보나치 수 7
import sys
sys.setrecursionlimit(int(1e9))

n = int(sys.stdin.readline().rstrip())
matrix = [[1,1],[1,0]]
fibo = [[1],[1]]
mod_num = 1000000007


def multi(m1,m2):
    global mod_num
    multi_result = [[0] * len(m2[0]) for _ in range(len(m1))]
    for i in range(len(m1)):
        for j in range(len(m2[0])):
            for k in range(len(m1[0])):
                multi_result[i][j] += (m1[i][k] * m2[k][j]) % mod_num
    return multi_result


def power_matrix(matrix,n):
    if n == 1: return matrix
    elif n%2: return multi(power_matrix(matrix,n-1),matrix)
    else: return power_matrix(multi(matrix,matrix),n//2)

if n <= 2: print(1)
else: print(multi(power_matrix(matrix,n-2),fibo)[0][0] % mod_num)