"""
Program to store new vocabulary words.
@author Vincent Zhang
@since 13 December 2021

Acknowledgements
BeautifulSoup usage on vocabulary.com
https://codezup.com/web-scraping-word-meaning-dictionary-python-beautifulsoup/

subprocess.call()
https://stackoverflow.com/questions/832331/launch-a-webpage-on-a-firefox-win-tab-using-python
"""

import subprocess
import urllib.request
from bs4 import BeautifulSoup # HTML parser

word = ''
url = ''
file_path = ''

def print_soup_data_by_class(soup, cls_name, title):
    """Return data in soup under label cls_name.
    """
    text = soup.find(class_=cls_name)
    if text == None: # In case cls_name does not exist in soup.
        return
    
    print('='*10 + title + '='*10)
    print(text.get_text().strip())
    print('\n')

def get_soup():
    """Return valid soup object based on user input word.
    Valid means word with a short meaning.
    """
    global word, url

    while 1:
        word = ' '.join(input("Enter word: ").strip().split()) # Replace whitespace with space.
        if not word: # Do not process enter which directs to "word of the day"
            continue

        url = f"https://www.vocabulary.com/dictionary/{word.replace(' ', '%20')}"

        htmlfile = urllib.request.urlopen(url)
        soup = BeautifulSoup(htmlfile, 'lxml')

        meaning_short = soup.find(class_="short")

        if meaning_short:
            return soup

        print("Word unavailable.") # None or empty string: no meaning.


def process_visit():
    """Visit the website if requested by user. E.g., for pronunciation.
    """
    search = input('Visit website? [Enter for no] [Any other key for yes]')
    if search:
        subprocess.call([r'C:\Program Files\Mozilla Firefox\Firefox.exe', '-new-tab', url])


def save_word():
    """Save word to file specified at the start of the program execution by the user.
    """
    with open(file_path, 'a') as file:
        file.write(f'{word}\n')


def main():
    """One iteration of program execution.
    """
    soup = get_soup()
    print_soup_data_by_class(soup, "short", 'SHORT MEANING')
    print_soup_data_by_class(soup, "long", 'LONG MEANING')
    print_soup_data_by_class(soup, "instances", 'INSTANCES') # Synonyms, Antonyms
    save_word()
    process_visit()


def init():
    """Set up file path and control flow of program.
    """
    global file_path
    file_path = input("Enter path to save file to: ")
    while 1:
        main()


if __name__ == '__main__':
    init()
