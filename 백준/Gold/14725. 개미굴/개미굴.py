#트라이 구조(문자열 저장하고 탐색하기 위한 트리) 사용
import sys

class Trie:
    def __init__(self): #생성자로 루트노드의 자식을 딕셔너리 구조로 선언
        self.root = {}

    def add(self, foods):
        cur = self.root #루트노드 부터 탐색하여 add(cur = current node)

        for food in foods:
            if food not in cur: 
                cur[food] = {} #해당 노드의 자식 생성(자식도 딕셔너리 구조)
            cur = cur[food] #생성된 자식으로 변경
        cur[0] = True #마지막에 리프노드

    def dfs(self, floor, cur):
        if 0 in cur: #리프노드가 나오면 stop
            return
        cur_child = sorted(cur) #알파벳 순으로 정렬
        for c in cur_child:
            print("--" * floor + c) #계층만큼 출력 후 다음 계층으로
            self.dfs(floor+1,cur[c])

N = int(sys.stdin.readline().rstrip())
trie = Trie()
for _ in range(N):
    input_list = list(map(str, sys.stdin.readline().split()))
    trie.add(input_list[1:])
trie.dfs(0, trie.root)

