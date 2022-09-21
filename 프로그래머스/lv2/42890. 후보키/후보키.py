from itertools import combinations

def solution(relation):
    num = [i for i in range(len(relation[0]))] #속성 별로 조합을 위한 리스트
    zip_relation = list(zip(*relation)) #속성 별로 리스트 구성
    temp_result = [] #유일성 만족하는 조합
    
    #유일성 판별
    for i in range(1,len(relation[0])+1):
        com_num = list(combinations(num,i))
        for com in com_num:
            temp = []
            for c in com:
                temp.append(zip_relation[c])
            temp = list(zip(*temp))
            if len(set(temp)) == len(relation):
                temp_result.append(com)
    
    #discard를 위한 set설정
    set_result = set(temp_result)
    
    #최소성 판별
    for i in range(len(temp_result)):
        for j in range(i+1,len(temp_result)):
            if len(temp_result[i]) == len(set(temp_result[i]) & set(temp_result[j])):
                set_result.discard(temp_result[j])
    
    return len(set_result)