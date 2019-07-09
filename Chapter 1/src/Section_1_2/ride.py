"""
ID: huskydj1
LANG: PYTHON3
TASK: ride
"""
f = open("ride.in", "r")
r = open("ride.out", "w")

a = f.readline()[:-1]
b = f.readline()[:-1]

aProduct = 1
for c in a:
    aProduct = aProduct * (ord(c)- 64)

bProduct = 1
for c in b:
    bProduct = bProduct * (ord(c)-64)

if (aProduct%47)==(bProduct%47):
    r.write("GO\n")
else:
    r.write("STAY\n")

f.close()
r.close()
