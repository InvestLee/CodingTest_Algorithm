import sys

#끝자리 부터 0의 갯수 = 각 숫자에서 2와 5의 갯수 쌍
def ssang(a,b): #예시 : 1~10까지의 2의 배수의 갯수는 5개=>1~5까지의 2의 배수 갯수는 2개
    count = 0
    while a != 0:
        a //= b
        count += a
    return count

n, m = map(int, sys.stdin.readline().split()) 
two_count = ssang(n,2) - ssang(m,2) - ssang((n-m),2) #이항계수의 2의 갯수
five_count = ssang(n,5) - ssang(m,5) - ssang((n-m),5) #이항계수의 5의 갯수
print(min(two_count,five_count)) #둘 중 작은 값이 2와 5의 쌍