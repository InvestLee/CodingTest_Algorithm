from collections import defaultdict

def solution(want, number, discount):
    result = 0
    buy = defaultdict(int)
    #처음 10일
    for i in range(10):
        buy[discount[i]] += 1
    for j in range(len(want)):
        if buy[want[j]] < number[j]:
            break
    else: #원하는 제품과 수량이 10일 연속 일치하는 경우
        result += 1
        
    #10일 이후
    for i in range(10,len(discount)):
        buy[discount[i]] += 1
        buy[discount[i-10]] -= 1
        for j in range(len(want)):
            if buy[want[j]] < number[j]:
                break
        else: #원하는 제품과 수량이 10일 연속 일치하는 경우
            result += 1
            
    return result