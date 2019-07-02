"""
ID:wonup2
LANG:PYTHON3
TASK:milk2
"""

r = set()

fin = open('milk2.in','r')
N = int(fin.readline())
for i in range(N):
    s, e = map(int, fin.readline().split())
    r.update(range(s,e))

s, e = min(r), max(r)

l = [int(i in r) for i in range(s,e+1)]
s = ''.join(list(map(str, l)))
print(s)

milk = len(max(s.split('0'), key = len))
idle = len(max(s.split('1'), key = len))

fout = open('milk2.out','w')
fout.write(str(milk) + ' ' + str(idle) + '\n')

fin.close()
fout.close()
