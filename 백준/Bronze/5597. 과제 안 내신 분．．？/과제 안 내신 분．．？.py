import sys

student_num = set()

for _ in range(28):
    student_num.add(int(sys.stdin.readline().rstrip()))

for i in range(1,31):
    if i not in student_num:
        print(i)