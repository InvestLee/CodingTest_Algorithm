import sys

L = int(sys.stdin.readline().rstrip())
#알파벳 소문자 당 번호 기입 a = 97-96, z = 122-96
dict = {chr(i):i-96 for i in range(97,123)} 
hash_str = list(str(sys.stdin.readline().rstrip()))

result = 0
for i in range(len(hash_str)):
    result += dict[hash_str[i]]*(31**i) #해쉬값 연산

print(result % 1234567891)