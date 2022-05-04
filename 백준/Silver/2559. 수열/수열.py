import sys
from itertools import accumulate
N, K = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().split()))
acc_num = list(accumulate(num)) #누적합
result = []
result.append(acc_num[K-1]) #수열 시작 부분 
for i in range(K,N):
    result.append(acc_num[i]-acc_num[i-K]) #누적합된 수에서 K만큼 차이나는 수를 빼주면 수열 생성
print(max(result))