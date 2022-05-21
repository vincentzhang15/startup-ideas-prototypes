"""
Program to extract lines from a file 'ExtractByStr_Input' by checking if a line contains a 'key' defined in 'ExtractByStr_Key.txt'.
All lines with 'key' will be exported without 'key' to 'ExtractByStr_Output_{CURRENT_DATE_&_TIME}.txt'.

@author Vincent Zhang
@since 2022-04-30
"""

import datetime

def main():
    # Get string to extract by.
    key_file = open("ExtractByStr_Key.txt", 'r', encoding="UTF-8")
    key = key_file.readline().rstrip('\n')
    key_file.close()

    # Store all extracted lines in 'result'.
    result = []
    with open("ExtractByStr_Input.txt", 'r', encoding="UTF-8") as f:
        for line in f:
            line = line.strip()
            if key in line:
                result.append(line.replace(key, ""))

    # Export data to file.
    s = str(datetime.datetime.now()).replace(" ", "_").replace(":", ".")
    with open(f"ExtractByStr_Output_{s}.txt", 'w', encoding="UTF-8") as f:
        for line in result:
            f.write(line)
            f.write("\n")
            print(line)

if __name__ == '__main__':
    main()
