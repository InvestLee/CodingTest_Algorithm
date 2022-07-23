def solution(n):
    global result
    result = 0
    row = [0]*n
    def check_possible(x):
        for i in range(x):
            if row[x] == row[i] or abs(row[x]-row[i]) == abs(x-i):
                return False
        return True
    def N_Queen(x):
        global result
        if x == n:
            result += 1
            return
        for i in range(n):
            row[x] = i
            if check_possible(x):
                N_Queen(x+1)
            
    N_Queen(0)
    return result