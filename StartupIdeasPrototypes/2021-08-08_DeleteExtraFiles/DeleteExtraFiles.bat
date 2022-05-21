set /p directory="Enter directory: "
%directory:~0,2%
cd %directory%
del *.exe
del *.class
del *.hi
del *.o
del *.txt
pause