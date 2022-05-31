import sys

T = int(sys.stdin.readline().rstrip())

# NO인 경우1 : 두 괄호 기호의 수가 동일하지 않은 경우
# NO인 경우2 : ")"의 갯수가 "("의 갯수보다 많아지는 시점이 있으면 NO

for _ in range(T):
    arr = list(map(str, sys.stdin.readline().rstrip()))
    left_count = 0 
    right_count = 0
    for i in arr:
        if i == "(":
            left_count += 1
        else:
            right_count += 1
        if right_count > left_count:
            break
    if right_count == left_count:
        print("YES")
    else:
        print("NO")