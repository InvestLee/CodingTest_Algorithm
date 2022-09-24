def solution(N, number):
    #최솟값이 8보다 크면 -1을 return
    dp = [set() for _ in range(9)]
    for i in range(1,9):
        dp[i].add(int(str(N)*i))
        # j+(i-j) = i, i를 만들 수 있는 모든 조합
        for j in range(i//2+1):
            for x in dp[j]:
                for y in dp[i-j]:
                    #모든 사칙연산 수행
                    dp[i].add(x+y)
                    dp[i].add(x*y)
                    dp[i].add(x-y)
                    dp[i].add(y-x)
                    if x != 0: dp[i].add(y//x)
                    if y != 0: dp[i].add(x//y)
                    
    for i in range(len(dp)):
        if number in dp[i]:
            return i
    return -1