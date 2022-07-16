import sys

N = int(sys.stdin.readline().rstrip())

class Node(): #이진 트리 클래스
    def __init__(self, item, left, right):
        self.item = item
        self.left = left
        self.right = right

tree = {} #이진 트리 딕셔너리
for _ in range(N):
    node, left, right = map(str, sys.stdin.readline().split())
    tree[node] = Node(node, left, right)

def preorder(node): #전위 순회
    print(node.item,end='')
    if node.left != '.' : preorder(tree[node.left])
    if node.right != '.' : preorder(tree[node.right])

def inorder(node): #중위 순회
    if node.left != '.' : inorder(tree[node.left])
    print(node.item,end='')
    if node.right != '.' : inorder(tree[node.right])

def postorder(node): #후위 순회
    if node.left != '.' : postorder(tree[node.left])
    if node.right != '.' : postorder(tree[node.right])
    print(node.item,end='')

preorder(tree['A'])
print()
inorder(tree['A'])
print()
postorder(tree['A'])