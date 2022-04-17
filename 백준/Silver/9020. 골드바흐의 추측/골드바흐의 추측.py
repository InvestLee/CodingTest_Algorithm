import sys
import math

T = int(sys.stdin.readline().rstrip())

for i in range(T):
    N = int(sys.stdin.readline().rstrip())
    veri = [True] * (N+1)
    veri[0], veri[1] = False, False
    Sosu = []
    result = []
    for i in range(2, int(math.sqrt(N))+1): #에라토스테네스의 채
        if veri[i] == True:
            j = 2
            while i*j <= N:
                veri[i*j] = False
                j += 1

    for i in range(N+1): #N이하 소수 리스트
        if veri[i] == True:
            Sosu.append(i)
    
    for i in Sosu: #2개의 소수를 더하여 N을 만들 수 있는 소수의 리스트 생성
        Temp = N
        if Temp-i <= 1: #1은 소수가 아니므로 제외
            continue
        else:
            Temp -= i #임시값에서 소수를 뺸다.
            if Temp in Sosu and N == i+Temp and i<=Temp: #i가 더 크고 소수끼리의 합이 N이라면
                result.append([i, Temp]) #2차 행렬로 더 한다.
    
    mini = N #최솟값
    A, B = 0, 0 #출력값
    for i in result:
        if (i[1] - i[0]) < mini: #최솟값보다 작으면 이게 최솟값
            mini = i[1] - i[0]
            A, B = i[0], i[1]
    print("%d %d"%(A,B))