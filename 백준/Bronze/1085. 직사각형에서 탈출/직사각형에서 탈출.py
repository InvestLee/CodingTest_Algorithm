import sys

x,y,w,h = map(int, sys.stdin.readline().split())
A = [x,y,w-x,h-y] #각 변과 만나기 위한 거리의 최솟값을 구하기 위함
print(min(A))