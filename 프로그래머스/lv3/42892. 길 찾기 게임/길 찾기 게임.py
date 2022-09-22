import sys
sys.setrecursionlimit(int(1e9))

def solution(nodeinfo):
    #노드 번호에 맞는 좌표 매기기
    node_list = [[i+1] for i in range(len(nodeinfo))] 
    for i in range(len(nodeinfo)):
        node_list[i].append(nodeinfo[i])
    #y : 내림차순, x : 오름차순 정렬
    node_list.sort(key= lambda x:(-x[1][1],x[1][0]))
    #시간복잡도를 위한 딕셔너리 처리
    node_dict = dict(node_list)
    #트리의 빈공간을 -1로 표현
    tree = {}
    for i in range(1,len(nodeinfo)+1):
        tree[i] = [-1,-1]
    
    #이진 트리 구성
    def binary_tree(parent,node):
        node_x = node_dict[node][0] #해당 노드
        while True: #자리를 찾을 때 까지 반복
            parent_x = node_dict[parent][0] #부모 노드(루트노드부터 시작하여 찾아야 됨)
            #좌측
            if parent_x > node_x:
                if tree[parent][0] == -1:
                    tree[parent][0] = node
                    break
                else: #빈 자리를 찾을 때까지 재귀적으로 구성
                    parent = tree[parent][0]
            #우측
            else:
                if tree[parent][1] == -1:
                    tree[parent][1] = node
                    break
                else: #빈 자리를 찾을 때까지 재귀적으로 구성
                    parent = tree[parent][1]
        
    #루트노트,해당노드 순서로 삽입하여 이진트리 구성
    for i in range(1, len(tree)):
        binary_tree(node_list[0][0],node_list[i][0])
    
    result = [[],[]]
    #전위 순회
    def preorder(node):
        if node != -1:
            result[0].append(node)
            preorder(tree[node][0])
            preorder(tree[node][1])
    #후위 순회
    def postorder(node):
        if node != -1:
            postorder(tree[node][0])
            postorder(tree[node][1])
            result[1].append(node)
    
    preorder(node_list[0][0])
    postorder(node_list[0][0])
    
    return result