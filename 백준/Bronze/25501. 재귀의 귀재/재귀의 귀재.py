import sys

def recursion(s, l, r):
    if l >= r: return 1
    elif s[l] != s[r]: return 0
    else: 
        call_number.append(1)
        return recursion(s, l+1, r-1)

def isPalindrome(s):
    return recursion(s, 0, len(s)-1)

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    S = sys.stdin.readline().rstrip()
    call_number = [1]
    return_value = isPalindrome(S)
    print(return_value, len(call_number))