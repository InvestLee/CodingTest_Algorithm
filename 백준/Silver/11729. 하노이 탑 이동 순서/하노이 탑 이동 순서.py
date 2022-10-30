import sys
sys.setrecursionlimit(int(1e9))

N = int(sys.stdin.readline().rstrip())

def hanoi(n, from_rod, to_rod):
    if n == 1:
        print(from_rod, to_rod)
        return

    #N-1개의 원판을 기존 장대에서 6(장대 번호의 합)-시작지점-목표지점으로 옮김
    hanoi(n-1,  from_rod, 6-from_rod-to_rod)
    #가장 큰 원판을 목표 막대로 옮겨줌
    print(from_rod, to_rod)
    #N-1개의 원판을 6(장대 번호의 합)-시작지점-목표지점에서 목표지점으로 옮김
    hanoi(n-1,  6-from_rod-to_rod, to_rod)

#총 이동 횟수 : (n-1) 하노이 이동수 * 2 + 1(가장 큰 원판 이동)
cnt = 0
for _ in range(N):
    cnt = 2*cnt+1
print(cnt)
hanoi(N, 1, 3)