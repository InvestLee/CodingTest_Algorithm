import sys

N = int(sys.stdin.readline().rstrip())
F0 = [1,0] #0이 나오는 횟수 메모이제이션
F1 = [0,1] #1이 나오는 횟수 메모이제이션
T = [] #테스트 리스트

for i in range(N):
    T.append(int(sys.stdin.readline().rstrip()))

MaxN = max(T) #케이스만큼 반복안하게 최댓값으로 한방에

for i in range(2,MaxN+1):
    F0.append(F0[i-1]+F0[i-2]) #횟수도 피보나치 반복한다.
    F1.append(F1[i-1]+F1[i-2]) #횟수도 피보나치 반복한다.

for i in T:
    print("%d %d"%(F0[i],F1[i]))