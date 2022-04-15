import sys

N = int(sys.stdin.readline().rstrip())
L = [0] * 10001 #append로 하나하나 넣는거보다 처음부터 10000개 만드는게 메모리 효율적
for i in range(N):
    L[int(sys.stdin.readline().rstrip())] += 1 #입력하는 위치에 더한다.

for i in range(10001):
    if L[i] != 0: #0은 다 지나치자
        for j in range(L[i]): #몇번 쓰였는지
            print(i)
