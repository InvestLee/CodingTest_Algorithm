def solution(elements):
    double_elements = elements * 2 #원형 수열로 사용하기 위해 늘리기
    result = set()
    for i in range(1,len(elements)+1): #길이
        for j in range(0,len(elements)): #시작 부분
            result.add(sum(double_elements[j:j+i]))
    return len(result)