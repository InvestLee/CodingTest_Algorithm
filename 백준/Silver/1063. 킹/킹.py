import sys

ord("A")-65
king, stone, N = map(str, sys.stdin.readline().split())
#명령어 이동
dict_move = {"R":[0,1],"L":[0,-1],"B":[-1,0],"T":[1,0],"RT":[1,1],"LT":[1,-1],"RB":[-1,1],"LB":[-1,-1]}
#왕의 위치
kx, ky = int(king[1]), int(ord(king[0])-64)
#돌의 위치
sx, sy = int(stone[1]), int(ord(stone[0])-64)
for _ in range(int(N)):
    command_king = sys.stdin.readline().rstrip()
    #왕의 이동
    nkx = kx + dict_move[command_king][0]
    nky = ky + dict_move[command_king][1]
    if nkx < 1 or nkx > 8 or nky < 1 or nky > 8:
        continue
    #돌의 이동
    if nkx==sx and nky==sy:
        nsx = sx + dict_move[command_king][0]
        nsy = sy + dict_move[command_king][1]
        if nsx < 1 or nsx > 8 or nsy < 1 or nsy > 8:
            continue
        sx, sy = nsx, nsy
    kx, ky = nkx, nky
print(chr(ky+64)+str(kx))
print(chr(sy+64)+str(sx))