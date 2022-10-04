#투 포인터, 부분합, 에라토스테네스의 채

import sys

N = int(sys.stdin.readline().rstrip())

#에라토스테네스의 채
prime_num = [False] * (N+1)
for i in range(2, int(N**(1/2))+1):
    j = 2
    while i*j <= N:
        prime_num[i*j] = True
        j += 1

#소수목록
prime_num_list = []
for i in range(2,N+1):
    if not prime_num[i]:
        prime_num_list.append(i)

#투 포인터
start = 0
end = 0
result = 0
if N != 1: sum_num = prime_num_list[0]
else: sum_num = 0
while True:
    if sum_num == N:
        result += 1
    if sum_num < N:
        end += 1 #End 이동시 이동한 end index의 값을 더해 준다.
        if end >= len(prime_num_list):
            break
        sum_num += prime_num_list[end]
    else:
        sum_num -= prime_num_list[start] #start 이동 전 start index의 값을 더해 준다.
        start += 1
        if start >= len(prime_num_list):
            break

print(result)