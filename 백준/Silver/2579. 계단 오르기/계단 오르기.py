import sys

#(마지막 계단+그 전 계단+그 전전전 계단까지의 최댓값)vs(마지막 계단+그 전전 계단까지의 최댓값)

Stair = int(sys.stdin.readline().rstrip())
Score = [0] * 300
for i in range(Stair):
    Score[i] = int(sys.stdin.readline().rstrip())

memo = [0] * 300 #메모이제이션
memo[0] = Score[0]
memo[1] = Score[0]+Score[1]
memo[2] = max(Score[1]+Score[2],Score[0]+Score[2])

for i in range(3, Stair):
    memo[i] = max(Score[i]+memo[i-2],Score[i]+Score[i-1]+memo[i-3]) 
print(memo[Stair-1])