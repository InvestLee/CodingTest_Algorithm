#각 기호 간 우선순위를 구분 
#1. (,)
#2. *,/
#3. +,- 

import sys

infix = sys.stdin.readline().rstrip()
stack_arith = []
result = ''

for i in infix:
    if i.isalpha(): #피연산자일시 결과에 삽입
        result += i
    else:
        #괄호를 이용하여 우선순위를 구별하기 위해 스택에 삽입
        if i == '(': 
            stack_arith.append(i)
        #곱셈, 나눗셈이 우선순위가 높으므로 동등 우선순위 연산자 이전까지 결과에 삽입
        elif i == '*' or i == '/':
            while stack_arith and (stack_arith[-1] == "*" or stack_arith[-1] == "/"):
                result += stack_arith.pop()
            stack_arith.append(i) #스택 삽입
        #덧셈, 뺄셈이 우선순위가 최하위이므로 괄호로 인한 우선순위 변동만 고려하여 결과에 삽입
        elif i == '+' or i == '-':
            while stack_arith and stack_arith[-1] != "(":
                result += stack_arith.pop()
            stack_arith.append(i) #스택 삽입
        #괄호가 닫혔으므로 괄호 내 연산자 모두 스택 삽입
        elif i == ')':
            while stack_arith and stack_arith[-1] != "(":
                result += stack_arith.pop()
            stack_arith.pop() #괄호 역할이 끝났으니 ( 삭제

#스택에 남은 연산자 모두 삽입
while stack_arith:
    result += stack_arith.pop()

print(result)
