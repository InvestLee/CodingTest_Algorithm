from itertools import combinations
from collections import defaultdict
from bisect import bisect_left

#이분탐색 라이브러리 사용법
#combinations(리스트,갯수) 사용법
#defaultdict 딕셔너리 초기값 지정가능(자료형,초기값 지정으로 인한 편리성)

def solution(info, query):
    answer = []
    dic = defaultdict(list)
    for i in info:
        i = i.split()
        i_str = i[:-1]
        i_val = int(i[-1])
        for j in range(5): #하나의 지원자 정보에 대한 모든 경우
            for c in combinations(i_str,j):
                temp = ''.join(c)
                dic[temp].append(i_val) #해당되는 딕셔너리의 리스트에 점수 추가
    for k in dic.keys():
        dic[k].sort() #이분 탐색을 위한 정렬
        
    for q in query:
        q = q.split()
        q_str = q[:-1]
        q_score = int(q[-1])
        for i in range(3):
            q_str.remove('and')
        while '-' in q_str:
            q_str.remove('-')
        temp_q = ''.join(q_str)
        answer.append(len(dic[temp_q])-bisect_left(dic[temp_q],q_score)) #해당되는 갯수
    return answer