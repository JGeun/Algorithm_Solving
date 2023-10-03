unit = {"A+": 4.5, "A0": 4.0, "B+": 3.5, "B0": 3.0, "C+": 2.5, "C0": 2.0, "D+": 1.5, "D0": 1.0, "F": 0.0}

creditSum = 0
majorSum = 0.0

for i in range(20):
    data = input().split()

    if data[2] == "P":
        continue

    credit = float(data[1])
    grade = unit[data[2]]
    majorSum += credit * grade
    creditSum += credit

print(majorSum/creditSum)
