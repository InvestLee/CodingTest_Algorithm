import sys

N = int(sys.stdin.readline().rstrip())
arr = []
for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().rstrip())))

#쿼드 트리로 8->4->2->1로 분할하여 각 영역이 모두 일치한다면 출력 그렇지 않다면 괄호
def Quad_Tree(x,y,R):
    color_arr = arr[x][y]
    for i in range(x,x+R):
        for j in range(y,y+R):
            if arr[i][j] != color_arr:
                #출력 순서 2사분면->1사분면->3사분면->4사분면
                print("(",end="")
                Quad_Tree(x,y,R//2) #2사분면
                Quad_Tree(x,y+R//2,R//2) #1사분변
                Quad_Tree(x+R//2,y,R//2) #3사분면
                Quad_Tree(x+R//2,y+R//2,R//2) #4사분면
                print(")",end="")
                return
    print(color_arr, end="")

Quad_Tree(0,0,N)