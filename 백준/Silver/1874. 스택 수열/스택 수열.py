import sys

n = int(sys.stdin.readline().rstrip())
want = []
for _ in range(n):
    want.append(int(sys.stdin.readline().rstrip()))
count = 0 #입력된 수열 탐색
stk = [] #스택
cal = [] #push(+), pop(-)를 담는 리스트

#원하는 입력된 수열의 요소랑 n번째 수랑 동일하기 직전까지 push
#동일하다면 스택에서 pop처리 후 다음 요소 탐색을 위해 count 증가->동일하지 않을떄까지 탐색
for i in range(1,n+1):
    stk.append(i)
    cal.append("+")
    while len(stk) != 0 and stk[-1] == want[count]:
        stk.pop()
        cal.append("-")
        count += 1

if cal.count("-") != n: #pop이 된 횟수 == 수열 요소의 갯수
    print("NO")
else:
    for c in cal:
        print(c)