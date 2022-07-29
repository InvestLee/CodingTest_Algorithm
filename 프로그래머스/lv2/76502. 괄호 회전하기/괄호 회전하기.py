from collections import deque

def solution(s):
    #올바른 괄호 문자열 체크
    #스택을 이용해서 괄호를 닫을 려면 열린 괄호가 직전에 있는지 확인 후 둘 다 제거
    def check(q):
        stack = []
        for bracket in q:
            if bracket == '(' or bracket == '{' or bracket == '[':
                stack.append(bracket)
            else:
                if len(stack) == 0:
                    return False
                before_bracket = stack.pop()
                if bracket == ')' and before_bracket != '(':
                    return False
                elif bracket == '}' and before_bracket != '{':
                    return False
                elif bracket == ']' and before_bracket != '[':
                    return False
        return len(stack) == 0 #괄호가 안 닫겨있으면 False
    
    result = 0
    q = deque(s)
    for _ in range(len(s)):
        q.rotate(-1)
        if check(q):
            result += 1
        
    return result