In this folder you may find the following:
1. Excel file which includes two sheets.
1.1 Sheet 1 contains comparisons of 4 different implementations, including troublesome one from the book.
1.2 Sheet 2 contains comparisons of 3 different implementations, excluding the one from the book.

2. Java files
Since I didn't have enough time to modify and polish my code, it is nor executable from the console,
but it needs to be modified inside some IDE in order to be tested. I hope you will accept in that way

-----------------------------------------------------
Specific Observations:
The last implementation of the matrix multiplication is considerably faster than sequential and other
implementations with threads. Since, I use i5 processor with 2 physical cores, last implementation is 
around 2x faster than sequential. I expect it to be 4x faster on processors with 4 physical cores.