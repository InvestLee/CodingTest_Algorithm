A = set(range(1,10001))
B = set()

for i in range(1,10001):
    for j in str(i):
        i += int(j)
    B.add(i)

C = sorted(A-B)
for i in C:
    print(i)