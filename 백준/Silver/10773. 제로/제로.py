import sys

N = int(sys.stdin.readline().rstrip())
arr = []
for i in range(N):
    let = int(sys.stdin.readline().rstrip())
    if let != 0:
        arr.append(let)
    else:
        arr.pop()
print(sum(arr))