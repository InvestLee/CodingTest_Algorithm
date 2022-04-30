import sys

def jegi(N,count):
    print('____'*count+'"재귀함수가 뭔가요?"')
    if count < N:
        print('____'*count+'"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.')
        print('____'*count+'마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.')
        print('____'*count+'그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."')
    else:
        print('____'*count+'"재귀함수는 자기 자신을 호출하는 함수라네"')
        print('____'*count+'라고 답변하였지.')
        return
    jegi(N,count+1)
    print('____'*count+'라고 답변하였지.') #재귀함수 뒤에 사용하여 쌓인 명령 출력하기(((()a)a)a)

N = int(sys.stdin.readline().rstrip())

print("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.")
jegi(N,0)