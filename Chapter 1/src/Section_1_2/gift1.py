"""
ID: huskydj1
LANG: PYTHON3
TASK: gift1
"""
fin = open("gift1.in", "r")
fout = open("gift1.out", "w")

a = int(fin.readline())
names = []
money = []

for i in range(a):
    names.append(fin.readline()[:-1])
    money.append(0)

for i in range(a):
    name = fin.readline()[:-1]

    tmp = list(fin.readline().split())

    total = int(tmp[0])
    num = int(tmp[1])

    if num ==0:
        continue

    money[names.index(name)] = money[names.index(name)]-total+total%num

    give = total//num

    for i in range(num):
        friend = fin.readline()[:-1]
        money[names.index(friend)] = money[names.index(friend)]+give


for i in range(a):
    fout.write(names[i] + " " + str(money[i])+"\n")

fin.close()
fout.close()
