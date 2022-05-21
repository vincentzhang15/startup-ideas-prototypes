"""
Program to automatically save screenshot by current time in seconds given by time.time().
@author Vincent Zhang
@since 17 December 2021
"""

import time	
import pyautogui

path = input("Save path: ")
if path[-1] != '\\':
	path += '\\'

while True:
	choice = input("'quit' to quit, enter to take screenshot: ")
	if choice == 'quit':
		break
	im = pyautogui.screenshot()
	im.save(f"{path}{round(time.time())}.jpg")
