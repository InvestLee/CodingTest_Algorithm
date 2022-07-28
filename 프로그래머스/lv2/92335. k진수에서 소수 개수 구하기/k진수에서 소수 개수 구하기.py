def solution(n, k):
    #k진수 구하기
    trans_num = []
    while n > 0:
        r = n % k
        n = n // k
        trans_num.append(r)
    trans_num = ''.join(map(str, trans_num[::-1])).split('0')
    
    #숫자 변환 및 1과 공백 삭제
    prime_test = []
    for t in trans_num:
        if t != '1' and t != '':
            prime_test.append(int(t))
    
    #소수 판별
    result = 0
    for p in prime_test:
        for i in range(2,int(p**(1/2))+1):
            if p%i == 0:
                break
        else:
            result += 1
    
    return result