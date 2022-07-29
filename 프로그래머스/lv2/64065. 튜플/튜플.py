def solution(s):
    #튜플 분리 및 정수형 변환
    s = s.split('},{')
    for i in range(len(s)):
        s[i] = s[i].replace('{','').replace('}','')
        s[i] = set(map(int, s[i].split(',')))
    s.sort(key=len)
    
    #set의 차집합 기능을 통한 연산
    result = [list(s[0])[0]]
    for i in range(1,len(s)):
        result.append(list(s[i] - s[i-1])[0])
    return result