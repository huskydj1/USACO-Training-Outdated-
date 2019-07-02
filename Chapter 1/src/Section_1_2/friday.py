"""
ID: huskydj1
LANG: PYTHON3
TASK: friday
"""

months = [3,  0,  3,  2,  3,  2,  3,  3,  2,  3,  2,  3]
"""
months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
         Jan  Feb Ma  Ap  My  Jn  Jl  Au  Sp  Oc  No  De
"""
days = [0, 0, 0, 0, 0, 0, 0]
"""     M  T  W  Th F  S  Su"""

fin = open("friday.in", "r")
fout = open("friday.out", "w")

n = int(fin.readline())
thirteen = 2
"""is 6 but accounting for adding"""
for i in range(n):
    year = 1900 + i
    #print(year)
    if (year%4 == 0 and year%100!=0) or year%400==0:
        months[1] = 1
    else:
        months[1] = 0

    for j in range(12):
        thirteen = (thirteen+months[(j-1+12)%12])%7
        days[thirteen] = days[thirteen]+1


fout.write(str(days[5])+" "+str(days[6])+" "+str(days[0])+" "+str(days[1])+" "+str(days[2])+" "+str(days[3])+" "+str(days[4])+"\n")

fin.close()
fout.close()
