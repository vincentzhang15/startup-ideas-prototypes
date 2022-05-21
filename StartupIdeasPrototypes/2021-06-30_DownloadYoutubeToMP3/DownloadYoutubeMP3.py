from __future__ import unicode_literals

"""
NEWLY LEARNT CONCEPTS SUMMARY

1. INSTALL FFmpeg
https://www.wikihow.com/Install-FFmpeg-on-Windows
https://www.gyan.dev/ffmpeg/builds/
Under GIT, Download https://www.gyan.dev/ffmpeg/builds/ffmpeg-git-full.7z

2. FFmpeg
https://en.wikipedia.org/wiki/FFmpeg
https://www.ffmpeg.org/about.html
Command-line based "video, audio, and other multimedia files and streams" handling "free and open-source software project."

3. Portmanteau
https://www.merriam-webster.com/dictionary/portmanteau#note-1
: a large suitcase
: a word or morpheme whose form and meaning are derived from a blending of two or more distinct forms (such as smog from smoke and fog)

3. Video codec
https://en.wikipedia.org/wiki/Video_codec
Portmanteau of encoder and decoder in video compression. "A video codec is software or hardware that compresses and decompresses digital video."
Compression is lossy, meaning data is lost when it is decompressed compared to its original pre-compressed state.

4. FFmpeg Guide
https://opensource.com/article/17/6/ffmpeg-convert-media-file-formats
At a very high-level view, a media file is broken up into:
    --> container: wrapper for the streams and interact with media players and tools
        --> e.g., ogg (Xiph.Org Foundation), mp4 (MPEG - Moving Picture Experts Group), webm (Google)
    --> streams, AV encoded with codec
        --> audio
        --> video
        --> subtitles, chapter information, or other metadata (depends on container)
        TYPES OF CODEC
            FLAC (Free Lossless Audio Codec)
            https://en.wikipedia.org/wiki/FLAC
            "audio coding format for lossless compression of digital audio"

            Vorbis
            https://en.wikipedia.org/wiki/Vorbis
            "designed to compete with MP3 in file size while offering better audio quality"

    EXAMPLE USE: CONVERT AUDIO CONTAINER
    ffmpeg -i input.mp3 output.ogg

5. from __future__ import [SOMETHING]
https://stackoverflow.com/questions/7075082/what-is-future-in-python-used-for-and-how-when-to-use-it-and-how-it-works
Force Python to use new features of the language that are not compatible with the current interpreter.

6. from __future__ import unicode_literals
https://stackoverflow.com/questions/23370025/what-is-unicode-literals-used-for
https://www.geeksforgeeks.org/unicode_literals-in-python/
Builds a unicode string instead of a "a byte string that holds UTF-8 encoded bytes"
unicode_literals makes string literals unicode.

7. UTF-8 VS Latin-1 (ISO/IEC 8859-1)
https://stackoverflow.com/questions/7048745/what-is-the-difference-between-utf-8-and-iso-8859-1
"UTF-8 is a multibyte encoding that can represent any Unicode character.
ISO 8859-1 is a single-byte encoding that can represent the first 256 Unicode characters. Both encode ASCII exactly the same way."

8. Basic Multilingual Plane (BMP)
https://en.wikipedia.org/wiki/Plane_%28Unicode%29#Basic_Multilingual_Plane
"Basic Multilingual Plane (BMP) contains characters for almost all modern languages, and a large number of symbols.
A primary objective for the BMP is to support the unification of prior character sets as well as characters for writing.
Most of the assigned code points in the BMP are used to encode Chinese, Japanese, and Korean (CJK) characters.
"

9. Surrogate Pairs
    https://docs.microsoft.com/en-us/globalization/encoding/surrogate-pairs
    https://stackoverflow.com/questions/5903008/what-is-a-surrogate-pair-in-java
    With surrogate pairs, a Unicode code point from
    range U+D800 to U+DBFF (called "high surrogate") gets combined with another Unicode code point from
    range U+DC00 to U+DFFF (called "low surrogate") to generate a whole new character, allowing the encoding of over one million additional characters.


    The term "surrogate pair" refers to a means of encoding Unicode characters with high code-points in the UTF-16 encoding scheme.

    In the Unicode character encoding, characters are mapped to values between 0x0 and 0x10FFFF.

    Internally, Java uses the UTF-16 encoding scheme to store strings of Unicode text. In UTF-16, 16-bit (two-byte) code units are used.
    Since 16 bits can only contain the range of characters from 0x0 to 0xFFFF, some additional complexity is used to store values above this range (0x10000 to 0x10FFFF).
    This is done using pairs of code units known as surrogates.

    The surrogate code units are in two ranges known as "high surrogates" and "low surrogates", depending on whether they are allowed at the start or end of the two-code-unit sequence.

10. Endianness
https://www.freecodecamp.org/news/what-is-endianness-big-endian-vs-little-endian/
"Endianness means that the bytes in computer memory are read in a certain order."
Data is often not READ in the same order when sharing data over the internet.
"Endianness is represented two ways Big-endian (BE) and Little-endian (LE)."
"
    BE stores the big-end first. When reading multiple bytes the first byte (or the lowest memory address) is the biggest - so it makes the most sense to people who read left to right.
    Big endian stores data MSbyte first
    BE is the dominant order in any network protocols, and is referred to as network order

    LE stores the little-end first. When reading multiple bytes the first byte (or the lowest memory address) is the littlest -  so it makes most sense to people who read right to left.
    Little endian stores data MSbyte last
    most PC's are little-endian
"
Bit ordering wtihin a byte doesn't matter as byte ordering is different in BE and LE.

11. Character Sets
https://stackoverflow.com/questions/2241348/what-is-unicode-utf-8-utf-16
ASCII (American Standard Code For Information Interchange)
    - 8 bits(1 byte) to represents a character
    - maximum of 256 (2^8) distinct combinations
    - only supports English
    
Unicode (Uniform character enCoding)
    - "Unicode assigns every character a unique number called a CODE POINT"
    - store other languages, symbols, and emojis
    - "We actually can not save the text as Unicode directly. Because Unicode is just an abstract representation of the text data."
    - first 256 code points are identical to ISO-8859-1, and hence also ASCII

UTF (Unicode Transformation Format): UTF is just an algorithm that turns Unicode into bytes and read it back
    - UTF-8 more memory efficient, less characters
        UTF-8: For the standard ASCII (0-127) characters, the UTF-8 codes are identical.
        This makes UTF-8 ideal if backwards compatibility is required with existing ASCII text.
        Other characters require anywhere from 2-4 bytes. This is done by reserving some bits in each of these bytes to indicate that it is part of a multi-byte character.
        In particular, the first bit of each byte is 1 to avoid clashing with the ASCII characters.
    - UTF-16
        Unicode 16-bit encoding system, over 65,000 characters can be encoded (2^16 = 65,536)
        "
        UTF-16: For valid BMP characters, the UTF-16 representation is simply its code point. However, for non-BMP characters UTF-16 introduces surrogate pairs.
        In this case a combination of two two-byte portions map to a non-BMP character. These two-byte portions come from the BMP numeric range,
        but are guaranteed by the Unicode standard to be invalid as BMP characters. In addition, since UTF-16 has two bytes as its basic unit, it is affected by endianness.
        To compensate, a reserved byte order mark can be placed at the beginning of a data stream which indicates endianness. Thus, if you are reading UTF-16 input,
        and no endianness is specified, you must check for this.
        "

"
    Memory considerations
    So how many bytes give access to what characters in these encodings?
        UTF-8:
            1 byte: Standard ASCII
            2 bytes: Arabic, Hebrew, most European scripts (most notably excluding Georgian)
            3 bytes: BMP
            4 bytes: All Unicode characters
        UTF-16:
            2 bytes: BMP
            4 bytes: All Unicode characters
    It's worth mentioning now that characters not in the BMP include ancient scripts, mathematical symbols, musical symbols, and rarer Chinese/Japanese/Korean (CJK) characters.
"

@author Vincent Zhang
@since 30 June 2021
"""

"""
Program to download YouTube video as mp3.
Based on: https://stackoverflow.com/questions/27473526/download-only-audio-from-youtube-video-using-youtube-dl-in-python-script
"""

import youtube_dl


ydl_opts = {
    'format': 'bestaudio/best',
    'postprocessors': [{
        'key': 'FFmpegExtractAudio',
        'preferredcodec': 'mp3',
        'preferredquality': '192',
    }],
}

link = input("Enter link: ")
with youtube_dl.YoutubeDL(ydl_opts) as ydl:
    ydl.download([link])