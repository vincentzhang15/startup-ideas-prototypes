"""
Program to remove duplicates in a file.
Elements are separated by whitespaces, e.g., new lines '\n'.
See example.

Input.txt
1 2 3 4 5
2 3 4 5 5
3 4 5 5 5
4 5 5 5 5
5 5 5 5 5

Output:
4
2
1
5
3

@author Vincent Zhang
@since 19 September 2021
"""

# Read input file and split file content by whitespaces. Remove by converting list to set.
with open('Input.txt', 'r', encoding='utf-8') as file:
    data = set(file.read().split())

# Print only unique elements.
for d in data:
    print(d)
