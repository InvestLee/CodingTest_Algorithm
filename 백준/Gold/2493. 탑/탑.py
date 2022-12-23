#좌측부터 탐색을 시작
#해당 타워보다 크기가 작은 타워들은 고려 대상이 아니므로 스택에서 제외
#연산 후 해당 타워를 추가

import sys

n = int(sys.stdin.readline().rstrip())
tower = list(map(int, sys.stdin.readline().split()))
stack = []
result = [0] * n

for i in range(n):
    while stack and tower[stack[-1]] < tower[i]:
        stack.pop()
    if stack:
        result[i] = stack[-1] + 1
    stack.append(i)

for r in result:
    print(r,end=" ")