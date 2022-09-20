def solution(msg):
    answer = []
    
    dic = {}
    for i in range(1,27):
        dic[chr(64+i)] = i
    
    save_num = 27 #등록번호
    start = 0
    while start < len(msg):
        #글자 탐색
        for end in range(start+1,len(msg)+1):
            if msg[start:end] not in dic:
                #등록이 안된 글자 등록
                dic[msg[start:end]] = save_num
                save_num += 1
                #색인번호 추가
                answer.append(dic[msg[start:end-1]])
                #다음 글자 지정
                start += end-1-start
                break
            #등록이 된 글자가 마지막일 경우
            elif end == len(msg) and msg[start:end] in dic:
                answer.append(dic[msg[start:end]])
                start += end-start
                break
    return answer