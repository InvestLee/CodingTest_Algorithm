import sys

N = int(sys.stdin.readline().rstrip())
temp1, temp2, temp3 = 0, 0, 0
count = 0

for i in range(1, N+1):
    if i < 100:
        count += 1
    elif i == 1000:
        break
    else:
        for j in str(i):
            temp1 = temp2
            temp2 = temp3
            temp3 = int(j)
        if (temp1-temp2) == (temp2-temp3):
            count += 1

print(count)
            