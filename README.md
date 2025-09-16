Leetcode 2405 - Optimal Partition of String (Java)

Problem StatementGiven a string s, partition it into unique segments according to the following procedure:



Start building a segment beginning at index 0.
Continue extending the current segment character by character until the current segment has not been seen before.
Once the segment is unique, add it to your list of segments, mark it as seen, and begin a new segment from the next index.
Repeat until you reach the end of s.
Return an array of strings segments, where segments[i] is the ith segment created.



My Solution , I solved this using a custom idea. I used a visit[] array to mark which characters are already used. Also used a HashSet to make sure the substrings we add are not repeated.

This logic passed all 732 testcases on Leetcode. I didn’t copy any solution and built this completely on my own logic.

 Runtime: 232 ms Submitted on: July 5, 2025  Author: Yash Gupta (Yash0100)

 Highlights

No letter is repeated in any part

Code is fully written using basic Java only

Simple and clear logic

Good for interviews or coding tests
