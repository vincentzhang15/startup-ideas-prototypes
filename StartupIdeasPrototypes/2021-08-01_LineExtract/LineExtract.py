"""
Program to extract lines in files with cyclic patterns.
Parameters include group size and line number.
For example to extract every odd number line:
	Group size = 2
	Line number = 1
The second line in every three lines:
	Group size = 3
	Line number = 2

@author Vincent Zhang
@since 01 August 2021
"""

path = input("Enter file path: ")
group = int(input("Enter group size: "))
extract = int(input("Enter line number to extract: "))

i=1
count = 0
with open(path, 'rb') as f:
	for line in f:
		if i == extract:
			print(str(line.strip())[1:].strip("'"))
			count += 1
		elif i == group:
			i = 0
		i += 1
print("Total:", count)