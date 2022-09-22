def solution(key, lock):
    #자물쇠 영역을 벗어나도 되도록 자물쇠 크기를 가로 세로 3배씩 커지게 하여 중앙 배치한다.
    global lock_length
    lock_length = len(lock)
    lock = lock * lock_length
    for i in range(len(lock)):
        lock[i] = lock[i] * lock_length
    
    #key 회전 함수
    def rotate(key):
        lotate_key = [[0] * len(key) for _ in range(len(key))]
        for i in range(len(key)):
            for j in range(len(key)):
                lotate_key[j][len(key)-1-i] = key[i][j]
        return lotate_key
    
    #자물쇠가 열리는지 체크
    def check(lock):
        global lock_length
        for i in range(lock_length,2*lock_length):
            for j in range(lock_length,2*lock_length):
                if lock[i][j] != 1:
                    return False
        return True
    
    for _ in range(4):
        for x in range(1,2*lock_length): #자물쇠 행 기준점
            for y in range(1,2*lock_length): #자물쇠 열 기준점
                #자물쇠에 열쇠 결합해보기
                for i in range(len(key)):
                    for j in range(len(key)):
                        lock[x+i][y+j] += key[i][j]
                #자물쇠 맞는지 확인
                if check(lock): return True
                #자물쇠에서 열쇠 제거
                for i in range(len(key)):
                    for j in range(len(key)):
                        lock[x+i][y+j] -= key[i][j]
        #열쇠 회전시키기
        key = rotate(key)
    return False