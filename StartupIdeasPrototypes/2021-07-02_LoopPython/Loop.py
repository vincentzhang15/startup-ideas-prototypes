"""
Python program to set clipboard contents line by line based on an input file.
@author Vincent Zhang
@since 02 July 2021
"""

"""
Copies text to clipboard.
@param s String to be copied to clipboard
@return void
"""
def copy(s):
	__import__("subprocess").check_call('echo ' + s.strip() + '|clip', shell=True)

with open('Input.txt', 'r') as f:
	for line in f:
		copy(line)
		print(line)
		input() # Wait for input to continue.
