import sys
N, M = map(int, sys.stdin.readline().split())
A = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(N)] #NxM 입력
count = 0 #색 변경이 필요한 정사각형 수 카운트
min = 50 * 50 #최소값 지정(조건에서 주워지는 최댓값으로 초기화)
for i in range(N-7): #모든 8X8 체스판을 도출하기 위한 범위
    for j in range(M-7):
        B = [A[k][j:j+8] for k in range(i,i+8)] #i,j를 기준으로 8X8 행렬 생성
        #왼쪽 위가 흰색의 경우와 검은색인 경우를 가정하여 두번 다 실행 최솟값 대입 실시
        for q in range(8): #8x8
            for p in range(8):
                if q % 2 == p % 2: #행렬의 위치의 성질(홀짝)이 같을때
                    if B[q][p] == 'B': #흰색이 아니면
                        count += 1 #변경해야하는 정사각형 카운트
                else: #행렬의 위치의 성질(홀짝)이 다를때
                    if B[q][p] == 'W': #검은색이 아니면
                        count += 1 #변경해야하는 정사각형 카운트
        if min > count: #카운트된 수가 최솟값보다 작으면
            min = count #최솟값 변경
        count = 0 #카운트 초기화
        #위 루프문과 반대의 경우 실시
        for q in range(8): #8x8
            for p in range(8):
                if q % 2 == p % 2: #행렬의 위치의 성질(홀짝)이 같을때
                    if B[q][p] == 'W': #검은색이 아니면
                        count += 1 #변경해야하는 정사각형 카운트
                else: #행렬의 위치의 성질(홀짝)이 다를때
                    if B[q][p] == 'B': #흰색이 아니면
                        count += 1 #변경해야하는 정사각형 카운트
        if min > count: #카운트된 수가 최솟값보다 작으면
            min = count #최솟값 변경
        count = 0 #카운트 초기화
print(min)