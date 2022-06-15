import sys

N = int(sys.stdin.readline().rstrip())
paper = []
for _ in range(N):
    paper.append(list(map(int, sys.stdin.readline().split())))

# [-1의 종이, 0의 종이, 1의 종이]
result = [0, 0, 0]

def slice_paper(x,y,N):
    global result
    #처음 종이 기준으로 같은지 다른지 판단
    paper_type = paper[x][y]
    for i in range(x,x+N):
        for j in range(y,y+N):
            if paper[i][j] != paper_type:
                #분할정복 3의 배수로 다르기 때문
                #수직방향(Vertical)
                for v in range(3):
                    #수평방향(Horizental)
                    for h in range(3):
                        slice_paper(x+N//3*v,y+N//3*h,N//3)
                return
    if paper_type == -1:
        result[0] += 1
    elif paper_type == 0:
        result[1] += 1
    else:
        result[2] += 1

slice_paper(0,0,N)
for r in result:
    print(r)