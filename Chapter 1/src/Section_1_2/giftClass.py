class person:
    def __init__(this, name, money):
        this.name = name
        this.money = money
    def data(this):
        return this.name + " " + this.money

fin = open("gift1.in", "r")
fout = open("gift1.out", "w")

n = int(fin.readline())

a = []

for i in range(n):
    a.append(person(fin.readline()[:-1], 0))

for i in range(n):
    giver = fin.readline()[:-1]
    total, p = map(int, fin.readline()[:-1].split())

    if p==0:
        continue
