import sys

arr = []
for _ in range(36):
    temp = sys.stdin.readline().rstrip()
    arr.append((ord(temp[0])-65,int(temp[1])-1))
#모든 칸을 방문했는지
if len(set(arr)) != 36:
    result = "Invalid"
#나이트처럼 이동했는지(처음칸 마지막칸 비교 포함)
else:
    result = "Valid"
    for i in range(36):
        a, b = abs(arr[i][0]-arr[i-1][0]), abs(arr[i][1]-arr[i-1][1])
        if a < 1 or a > 2 or b < 1 or b > 2 or a+b != 3:
            result = "Invalid"
            break
print(result)