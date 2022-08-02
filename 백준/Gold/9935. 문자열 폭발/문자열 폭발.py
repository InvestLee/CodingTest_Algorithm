import sys

str_list = str(sys.stdin.readline().rstrip())
bomb = str(sys.stdin.readline().rstrip())
stack_str = []
for i in range(len(str_list)):
    stack_str.append(str_list[i])
    #스택이 폭발 문자열보다 길고 가장 끝 부분이 폭발 문자열일때 폭발
    if len(stack_str) >= len(bomb) and ''.join(stack_str[-len(bomb):]) == bomb:
        for _ in range(len(bomb)):
            stack_str.pop()

result = ''.join(stack_str)
if len(result) == 0:
    print('FRULA')
else:
    print(result)