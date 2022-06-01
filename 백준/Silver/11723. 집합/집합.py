import sys

M = int(sys.stdin.readline().rstrip())
S = set()
for _ in range(M):
    command_set = list(map(str, sys.stdin.readline().split()))
    if len(command_set) == 1:
        if command_set[0] == 'all':
            S = set([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20])
        else:
            S = set()
        continue
    
    if command_set[0] == "add":
        S.add(int(command_set[1]))
    elif command_set[0] == "remove":
        S.discard(int(command_set[1]))
    elif command_set[0] == "check":
        if int(command_set[1]) in S:
            print(1)
        else:
            print(0)
    elif command_set[0] == "toggle":
        if int(command_set[1]) in S:
            S.discard(int(command_set[1]))
        else:
            S.add(int(command_set[1]))