import math

def solution(n, k):
    num_list = [i+1 for i in range(n)]
    result = []
    while len(num_list) != 0: #줄을 다 세울 때까지
        fac = math.factorial(n-1) #몇 등분할지에 대한 기준
        print((k-1)//fac)
        result.append(num_list.pop((k-1)//fac)) #0,1,2순서이므로 k-1
        n -= 1 #남은 숫자리스트 갯수만큼 감소
        k %= fac #다음 수는 몇번쨰인지
    return result