def separate_b(p): #분리 및 u 판별
        open_b, close_b = 0, 0
        check_b = True
        for i in range(len(p)):
            if p[i] == '(':
                open_b += 1
            else:
                close_b += 1
            if close_b > open_b:
                check_b = False
            if open_b == close_b:
                return p[:i+1], p[i+1:], check_b

def solution(p):
    if len(p) == 0: #1번 과정
        return ''
    
    u, v, check_b = separate_b(p) #2번 과정
    
    if check_b: #3번 과정
        return u + solution(v) #3-1번 과정
    else: #4번 과정
        result = '('+solution(v)+')' #4-1,2,3번 과정
        for c in u[1:len(u)-1]: #4-4번 과정
            if c == '(':
                result += ')'
            else:
                result += '('
    return result