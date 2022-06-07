import sys

#분할정복
#4사분면 좌표법으로 놔눈다(기준은 시작점인 2사분면)
#해당 좌표가 어느 사분면에 있는지 계산하는 방식
#2사분면으로 계속 사이즈를 축소하면서 이동하여 계산
#각 사분면은 좌표를 C와 사이즈 크기에서 순서의 곱만큼 빼준다
#카운트는 각 분할마다의 위치값(사이즈 크기 제곱에 순서 곱)해준다.

N, r, c = map(int, sys.stdin.readline().split())
result = 0

while N >= 1: #사이즈의 최소값 이상
    size_z = (2**N) // 2 #사분면을 나누는 기준 점
    if c < size_z and r < size_z: #2사분면
        pass #사이즈 크기 제곱 * 0
    elif c >= size_z and r < size_z: #1사분면
        result += size_z**2
        c -= size_z #축소된 사이즈로 좌표 수정
    elif c < size_z and r >= size_z: #3사분면
        result += size_z**2*2
        r -= size_z #축소된 사이즈로 좌표 수정
    elif c >= size_z and r >= size_z: #4사분면
        result += size_z**2*3
        c -= size_z #축소된 사이즈로 좌표 수정
        r -= size_z #축소된 사이즈로 좌표 수정
    N -= 1 #사이즈 축소
print(result)