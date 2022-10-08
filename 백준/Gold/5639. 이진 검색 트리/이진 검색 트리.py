import sys
sys.setrecursionlimit(int(1e9))

tree_preorder = []
while True:
    try:
        tree_preorder.append(int(sys.stdin.readline().rstrip()))
    except:
        break

def postorder(left,right):
    if left > right:
        return
    #해당 노드에서 우측 서브트리를 찾기(그 전까지는 좌측 서브트리)
    mid = right + 1 #우측 서브트리가 없는 경우
    for i in range(left+1, right+1):
        if tree_preorder[left] < tree_preorder[i]: 
            mid = i
            break
    #좌측 서브트리 우측 서브트리 구한 후 후위 순회
    postorder(left+1,mid-1) #좌측 서브트리
    postorder(mid,right) #우측 서브트리
    print(tree_preorder[left])

postorder(0, len(tree_preorder)-1)
