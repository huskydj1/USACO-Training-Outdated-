from collections import OrderedDict

fin = open("gift1.in", "r")
fout = open("gift1.out", "w")

a = OrderedDict()

n = int(fin.readline())

for i in range(n):
    a[fin.readline()[:-1]] = 0

for z in range(5):
    name = fin.readline()[:-1]

    money, d = map(int, fin.readline()[:-1].split())

    if d == 0:
        continue

    a[name]-=money
    a[name]+=money%d
    for i in range(d):
        a[fin.readline()[:-1]]+=money//d

for x, y in a.items():
    print(x + " " + str(y))
