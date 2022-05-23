import sys

#가장 큰 직사각형 넓이-비어있는 직사각형 넓이

K = int(sys.stdin.readline().rstrip())

arr = []
for _ in range(6):
    a, b = map(int, sys.stdin.readline().split())
    arr.append(b)

#가장 큰 넓이에서의 변 위치를 지정하여 이격된 변 위치가 빈 직사각형의 변
max_area = 0
for i in range(6):
    temp = arr[i] * arr[(i+1)%6]
    if max_area < temp:
        max_area = temp
        index = i

null_area = arr[(index+3)%6]*arr[(index+4)%6]

print((max_area-null_area)*K)