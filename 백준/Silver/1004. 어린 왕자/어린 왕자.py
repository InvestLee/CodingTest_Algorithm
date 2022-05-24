import sys

T = int(sys.stdin.readline().rstrip())

for _ in range(T):
    sx, sy, ex, ey = map(int, sys.stdin.readline().split())
    n = int(sys.stdin.readline().rstrip())
    result = 0
    for i in range(n):
        cx, cy, r= map(int, sys.stdin.readline().split())
        s_distance = (abs(sx-cx)**2+abs(sy-cy)**2)**(1/2)
        e_distance = (abs(ex-cx)**2+abs(ey-cy)**2)**(1/2)
        
        #현재 원이 출발점과 끝점의 포함여부를 통해 진입/이탈 필요성을 판별한다.
        if s_distance < r and e_distance > r:
            result += 1
        if s_distance > r and e_distance < r:
            result += 1
    print(result)