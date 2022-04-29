import sys

N = int(sys.stdin.readline().rstrip())
arr = []
for i in range(N):
    let = str(sys.stdin.readline().rstrip())
    if let[:4] == 'push':
        arr.append(int(let[5:]))
    elif let == 'pop':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr.pop())
    elif let == 'size':
        print(len(arr))
    elif let == 'empty':
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    else:
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[len(arr)-1])