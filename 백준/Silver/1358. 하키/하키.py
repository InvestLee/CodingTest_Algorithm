import sys

W, H, X, Y, P = map(int, sys.stdin.readline().split())
count = 0

#직사각형 영역에 포함되는지 먼저 판별한다 
#포함이 안된다면 좌측원 우측원 영역에 포함되는지 판별한다.
for _ in range(P):
    px, py = map(int, sys.stdin.readline().split())
    left_circle_distance = (abs(px-X)**2+abs(py-(Y+H/2))**2)**(1/2)
    right_circle_distance = (abs(px-(X+W))**2+abs(py-(Y+H/2))**2)**(1/2)
    if X <= px <= X+W and Y <= py <= Y+H:
        count +=1
    elif left_circle_distance <= H/2 or right_circle_distance <= H/2:
        count +=1
print(count)