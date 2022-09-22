def is_impossible(result):
    for x, y, a in result:
        if a == 0: #기둥일 때
            #바닥, 다른 기둥 그리고 보의 한쪽 끝 부분 위에 없는 경우
            if y != 0 and (x,y-1,0) not in result and (x-1,y,1) not in result and (x,y,1) not in result:
                return True
        else: #보일 때
            #기둥의 한쪽 끝 부분에 없고 양쪽 끝 부분이 다른 보와 동시에 연결되지 않은 경우
            if (x,y-1,0) not in result and (x+1,y-1,0) not in result and ((x-1,y,1) not in result or (x+1,y,1) not in result):
                return True
    return False

def solution(n, build_frame):
    result = set() #시간복잡도 고려
    #명령 이행 후 조건이 부합하지 않으면 복귀
    for x,y,a,b in build_frame:
        if b == 1:
            result.add((x,y,a))
            if is_impossible(result): 
                result.discard((x,y,a))
        else:
            result.discard((x,y,a))
            if is_impossible(result): 
                result.add((x,y,a))
    
    result = sorted(list(result))
    return result 