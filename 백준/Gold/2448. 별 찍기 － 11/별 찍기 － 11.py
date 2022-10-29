import sys
sys.setrecursionlimit(int(1e9))

N = int(sys.stdin.readline().rstrip())

def create_star(n):
    #default
    if n == 3:
        return ['  *  ',' * * ','*****']
    
    # N = 3 -> 6 -> 12 -> 24
    before = create_star(n//2)
    star = []
    #양 옆 공백 삽입
    for b in before:
        star.append(' '*(n//2)+b+' '*(n//2))
    #이전 과정의 모양이 아래로 2배씩 증가
    for b in before:
        star.append(b + ' ' + b)
    return star

print('\n'.join(create_star(N)))