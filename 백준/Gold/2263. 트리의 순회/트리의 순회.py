import sys
sys.setrecursionlimit(int(1e9))

n = int(sys.stdin.readline().rstrip())
inorder = list(map(int, sys.stdin.readline().split()))
postorder = list(map(int, sys.stdin.readline().split()))

#postorder의 맨마지막 원소는 루트 노드
#루트노드를 기준으로 왼쪽 서브 트리, 오른쪽 서브 트리 나눌 수 있음

#Location[Node] = index => inorder Node는 index위치에 있음
#postorder의 끝 Node가 inorder에서 어떤 위치에 있는지 알아내기 위함
index_inorder = [0] * (n+1)
for i in range(n):
    index_inorder[inorder[i]] = i

def preorder(inorder_start, inorder_end, postorder_start, postorder_end):
    if (inorder_start > inorder_end) or (postorder_start > postorder_end): return

    #postorder의 맨마지막 원소는 루트 노드
    root_node = postorder[postorder_end]
    print(root_node, end=" ")

    #루트노드를 기준으로 왼쪽 서브 트리, 오른쪽 서브 트리 나눌 수 있음
    left = index_inorder[root_node]-inorder_start
    right = inorder_end - index_inorder[root_node]

    #좌측 서브트리
    preorder(inorder_start, inorder_start + left - 1, postorder_start, postorder_start + left - 1)
    #우측 서브트리
    preorder(inorder_end - right + 1, inorder_end, postorder_end - right, postorder_end -1)

preorder(0, n-1, 0, n-1)