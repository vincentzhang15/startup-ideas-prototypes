"""
Program to calculate grade standing in a course.

Section 1: Obtained %
Section 2: Lost %
Section 3: Undetermined %
Section 4: Max Final Mark
Section 5: Current Average

@author Vincent Zhang
@since 30 November 2021
"""

import os

exact = False

direc = input("Enter input file directory: ")

data = []
with open(os.path.join(direc, 'CalculateGrade_Input.txt')) as f:
    for line in f:
        line = line.strip()
        if line == 'Calculation:exact': # Exact format takes numerator/denominator instead of direct percentage
            exact = True
        elif line == '$$END$$':
            break
        elif not (line == '' or line[0:2] == '$$'): # Skip comments and empty lines
            data.append(line)
data = list(map(lambda x: x.split(), data)) # Creates 2D list

if exact:
    for i in range(len(data)):
        data[i][0] = 100 * float(data[i][0]) / float(data[i].pop(1))

obtained = 0
subtotal = 0
for d in data:
    obtained += float(d[0]) * float(d[1]) / 100
    subtotal += float(d[1]) # sum of weights
if subtotal > 100: print(f"WARNING: total marks entered is: {subtotal}")
lost = subtotal - obtained
undetermined = 100 - subtotal
max_final = 100 - lost
average = obtained / (obtained + lost) * 100

print(f"Obtained: \t{obtained:.3f}%")
print(f"Lost: \t\t{lost:.3f}%")
print(f"Undetermined: \t{undetermined:.3f}%")
print(f"Max Final: \t{max_final:.3f}%")
print(f"Average: \t{average:.3f}%")
