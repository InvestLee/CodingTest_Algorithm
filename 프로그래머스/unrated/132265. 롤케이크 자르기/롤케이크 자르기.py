from collections import defaultdict

def solution(topping):
    result = 0
    
    #철수와 동생이 가진 토핑 종류 별 수량
    dict_old = defaultdict(int)
    dict_young = defaultdict(int)
    for t in topping: dict_young[t] += 1
    
    #철수와 동생이 가진 토핑 종류
    set_old = set()
    set_young = set(topping)
    
    #토핑 종류 계산
    for t in topping:
        dict_old[t] += 1 #토핑 종류 별 수량 갱신
        set_old.add(t) #철수 토핑 종류 갱신
        dict_young[t] -= 1
        if dict_young[t] == 0: #동생이 가진 토핑이 없으면
            set_young.remove(t) #동생 토핑 종류 갱신
        if len(set_old) == len(set_young):
            result += 1
    
    return result