"""
ID: huskydj1
LANG: PYTHON3
TASK: friday
"""
import datetime
days = [0, 0, 0, 0, 0, 0, 0]
"""     Su M  T  W  Th F  S"""

fin = open("friday.in", "r")
fout = open("friday.out", "w")

n = int(fin.readline())

for i in range(n):
    year = 1900 + i

    for j in range(1, 13):
        x = datetime.datetime(year, j, 13)
        days[int(x.strftime("%w"))]+=1


print(days)

fin.close()
fout.close()
