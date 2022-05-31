import sys

while True:
    str_arr = list(str(sys.stdin.readline().rstrip()))
    if str_arr[0] == ".": #종료 조건
        break
    #스택에 괄호만 추가할 것, 짝이 맞는 괄호는 pop 실행
    stk = []
    #짝이 어긋나거나 왼쪽이 존재하지 않는 오른쪽 괄호인 경우 False
    yes_no = True 
    for s in str_arr:
        if s == '(' or s == '[':
            stk.append(s)
        elif s == ')':
            if not stk or stk[-1] == '[':
                yes_no = False
                break
            elif stk[-1] == '(':
                stk.pop()
        elif s == ']':
            if not stk or stk[-1] == '(':
                yes_no = False
                break
            elif stk[-1] == '[':
                stk.pop()
    if not stk and yes_no == True:
        print('yes')
    else:
        print("no")