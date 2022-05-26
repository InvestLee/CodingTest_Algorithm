import sys

#백트래킹 재귀
#9->3->1->[*]->[***,* *,***]....
#출력시 join으로 \n하여 출력

N=int(sys.stdin.readline().rstrip())

def paint_star(N):
  if N==1:
    return ['*']
  star = paint_star(N//3)
  arr = []
  for s in star:
    arr.append(s*3)
  for s in star:
    arr.append(s+' '*(N//3)+s)
  for s in star:
    arr.append(s*3)
  return arr

print('\n'.join(paint_star(N)))