"""
Program to shorten a colloquial message using short forms. Below is an example.

Input.txt
Testing text with some words, let me know if this works, because I don't know about the very nice weather today and it wouldn't be don't would.

Output
Testing text w/ some words, lmk if this works, bc ion k bout the v nice weather today & it wudnt b dnt wud.

@author Vincent Zhang
@since 11 September 2021
"""

# Read the input file which contains the original message to be shortened.
with open('Input.txt', 'r', encoding="utf-8") as file:
    data = file.read().replace('’', "'")

# The dictionary of colloquialisms.
colloquialDict = {
    'with' : 'w/',
	'let me know' : 'lmk',
    'know' : 'k',
    'very' : 'v',
    'because' : 'bc',
    "I don't" : 'ion',
    'you' : 'u',
    'want to' : 'wanna',
    'please' : 'pls',
    'about' : 'bout',
    ' and' : ' &',
    'be ' : 'b ',
    "didn't" : 'ddnt',
    "wouldn't" : 'wudnt',
    'would' : 'wud',
    "don't" : 'dnt'
}

# Replace all occurances of a word that can be shortened with its short form.
for k, v in colloquialDict.items():
    data = data.replace(k, v)
print(data)