def solution(triangle):
    for i in range(1,len(triangle)):
        for j in range(len(triangle[i])):
            #해당 지점이 왼쪽 벽에 붙은 경우
            if j == 0: 
                triangle[i][j] += triangle[i-1][j]
            #해당 지점이 오른쪽 벽에 붙은 경우
            elif j == len(triangle[i])-1:
                triangle[i][j] += triangle[i-1][j-1]
            else:
                triangle[i][j] += max(triangle[i-1][j],triangle[i-1][j-1])
    return max(triangle[len(triangle)-1])