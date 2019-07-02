class pair:
    def __init__(this, start, end):
        this.start = start
        this.end = end

fin = open("milk2.in", "r")
fout = open("milk2.out", "w")

n = int(fin.readline())

input = []
for i in range(n):
    x, y = map(int, fin.readline()[:-1].split())
    input.append(pair(x, y))
input.sort(key = lambda input: input.start)

a = []

for j in range(n):
    x = input[j]

    while (len(a)-1)<x.end:
        a.append("0")

    for i in range(x.start, x.end):
        a[i] = "1"
#print(a)
x=''.join(a)
#print(x)

s = x.split("0")
one = len(max(s, key=len))
s = x.split("1")
print(s)
zero = len(max(s, key=len))
print(str(one) + " " + str(zero))
