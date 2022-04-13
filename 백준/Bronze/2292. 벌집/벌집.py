import sys

N = int(sys.stdin.readline().rstrip()) #N번방 입력
T = 2 #T=T+6*i를 위한 초기값()
i = 0 #이동수 - 1
while True: #발견할떄 까지 무한 루프
    T += 6*i  #문제의 규칙
    if N < T: #N=1이면 어짜피 T=2이므로 작음
        print(i+1)
        break
    i += 1