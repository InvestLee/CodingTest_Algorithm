import sys

#남은 최소 자연수로 계속 빼면서 카운트하면 정답

N = int(sys.stdin.readline().rstrip())
count = 0
while N > count:
    count += 1
    N -= count
print(count)