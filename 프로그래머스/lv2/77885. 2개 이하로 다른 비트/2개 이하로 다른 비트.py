def solution(numbers):
    result = [] #2개 이하로 다른 비트를 남기 위한 리스트
    for n in numbers:
        if n % 2 == 0: #짝수인 경우 그 다음 수가 만족
            result.append(n+1)
        else:
            bin_num = format(n,'b') #양의 정수 x를 비트화
            for i in range(len(bin_num)-1,-1,-1):
                if bin_num[i] == '0': #가장 작은 위치의 0이랑 1이랑 바꾸면 만족
                    result.append(n+2**(len(bin_num)-i-2))
                    break
            else: #0이 없을 경우 2의 "가장 큰 1의 위치" 제곱만큼이 다음 수
                result.append(n+2**(len(bin_num)-1))
    return result