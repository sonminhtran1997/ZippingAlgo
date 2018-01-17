# Project 1 (Zip) Write-Up #
--------

#### How Was Your Partnership? ####
-   Did both partners do an equal amount of work?  If not, why not?
    If so, what did each person do? What happened?<pre>
**TODO**: Yes both of us do the same amount of work. I and him sit together in the lab every time to code the whole project. We do not work
individually for the whole project. Some class Son will be the person who code and Max will sit next to Son to instruct and vice versa. 
We basically do pair coding
</pre><br>

-----

#### Project Enjoyment ####
-   What was your favorite part of the project?  What was your least
    favorite part of the project?<pre>
**TODO**: The favorite part is we both come up with different solution, and we both learned that there are multiple ways to solve problem. Also, sometimes, on person struggled, and the other will be able to help up or figure out together. The least favorite part of the project is the debugging takes forever.
</pre><br>

-   Did you enjoy the project?  Why or why not?<pre>
**TODO**: We enjoy the first half of the project, because those are more straight forward, and it's directly from the class lecture. However, the second half of the class especially the delete method, we have to repeatedly check our logic to find out what is not correct. 
</pre><br>

-----

#### WorkLists, Tries, and Zip ####
-   The ADT for a WorkList explicitly forbids access to the middle elements.  However, the FixedSizeFIFOWorkList has a peek(i) method
    which allows you to do exactly that.  Why is this an acceptable addition to the WorkList ADT in this particular case but not in general?  
    In other words, what about fixed size FIFO worklists makes peek(i) make sense? Why does peek(i) NOT make sense in other worklist implementations?<pre>
**TODO**: In terms of fixed size, we know that the runtime of accessing element is always constant. Also, the FIFO worklist has a specific order. Generally, the worklist doesn't have the order of sorting elements. Therefore, if we want to peek(i) at an index, it doesn't make sense because there is no order. However, we a FIFO, we know the order of the worklist; therefore, it is good to use peek(i) at an index.
</pre><br>
-   As we've described it, a `TrieMap` seems like a general-purpose replacement for `HashMap` or `TreeMap`.  Why might we still want to use one
    of these other data structures instead?<pre>
**TODO**: The TrieMap has the benefit of categorize the type of data into a group(or like a branch). But for Hashmap and Treemap, it just considered the key as the single one which give a constant time to get a very specific element. 
Some case we should consider to use trie is for phone number, words. This is because, for phone number, sometimes we want to get all the
phone number with the area code which is a a first 3 prefix number of the phone number. This is for categorizing problem. Same with words.
The words should be considered as categorizing problem since some words can share same prefix.
However, we should not always use Trie. For example, in the problem we want to get the information of the student from student ID number,
using hashmap or treemap will always be better since we just need to pass the key to get function then we will get the result right away(0(1))
</pre><br>
-   One of the applications of Tries is in solving Word Searches.  A "word search" is an n x m rectangle of letters.  The goal is to find all
    of the possible words (horizontal, vertical, diagonal, etc.).  In Boggle, a similar game, any consecutive chain of letters
    are allowed.  Explain (in very high-level pseudo-code) how you might solve this problem with a TrieSet or a TrieMap.  Make sure to detail
    how a similar solution that uses a HashSet/HashMap instead would be different and why using a Trie might make the solution better.<pre>
**TODO**: Here is the step we gonna solve this problem. We will go check each character in the matrix from the very top left corner to the very bottom right corner.
 In each character we gonna traverse through each character of each direction that character go to. If that current spot is a valid word in the data structure word dictionary(Hashmap or Trie) then we will return that word and continue to go check all other direction spot until we reach to the end of the corner where there are no more direction to go or there is no valid direction to go. 
 The only different between using hashset or trie as the data structure for this project is that for hashset, we need to check 
all possible combination of each direction to make sure we do not miss any word in the matrix, on the other side, for trie, when we traverse and find out that there is no
other branch in the dictionary following right after that character spot we gonna break out at that direction so we can save the time from keep looping through unnecessary direction. 
</pre><br>
-   One of the classes in the main package is called Zip.  This class uses your PriorityQueue to do Huffman coding, your FIFOQueue as a buffer,
    your stack to calculate the keyset of a trie (using recursive backtracking), and your SuffixTrie to do LZ77Compression.  Find some text file
    (a free book from https://www.gutenberg.org/ or even the HTML of some website) and use Zip.java to zip it into a zip file.  Then, use a 
    standard zip utility on your machine (Finder on OS X, zip on Linux, WinZip or the like on Windows) to UNZIP your file.  Check that you got back
    the original.  Congratulations!  Your program correctly implements the same compression algorithm you have been using for years!  Discuss in a
    sentence or two how good the compression was and why you think it was good or bad.<pre>
**TODO**: I think the compression does work but it seems pretty slow as the size of the file increase. I think it is good to know that those data structure we implementation
are good for the compression algorithm, but I do not think this compression is practical in our daily using since it is still very slow.
</pre><br>
-   Now that you've played with Zip, we want you to do an **experiment** with Zip.  Notice that there is a constant called `BUFFER_LENGTH` in `Zip.java`.
    Higher values of this constant makes the compression algorithm that Zip uses use more memory and consequently more time.  The "compression ratio"
    of a file is the uncompressed size divided by the compressed size.  Compare time, type of input file, and compression ratio by running
    your code on various inputs.  We would like an in-depth analysis.  You should try at least one "book-like" file, at least one "website-like" file,
    and some other input of your choice.  We expect you to draw meaningful conclusions and possibly have graphs that convince us of your conclusions. 
    Say something about WHY you think you may have gotten the results you did.
    This single question is worth almost as much as the implementation of `ArrayStack`; so, please take it seriously.  If you spend less than 20 minutes
    on this question, there is no conceivable way that you answered this question in the way we were intending.<pre>
**TODO**: When we increase the buffer length, we can see the compression ratio increases rapidly. (See the excel file for more information).
		For a higher compress ration, the payoff is the compression time is also increased. Therefore, as we increase the buffer length, the time and the ratio are both increase too.
		For file type, as the file size increase, the compression ratio also increase, and the compression time also increases too.
</pre><br>

#### Above and Beyond ####
-   Did you do any Above and Beyond?  Describe exactly what you
    implemented.<pre>
**TODO**: Answer this question
</pre><br>
