# Project #3: Experiements with Hashing

* Author: Karter Melad
* Class: CS321 Section #001
* Semester: Fall 2023

## Overview

This project is an implementation of a Hashtable with open addressing. 
We can use this project to view the difference in probe counts when the 
load factor varies.

## Reflection

Overall this project was enjoyable to create but also caused unexpected
issues multiple times. I wrote the bulk of the code for this project very
quickly and spent the ramainder of the test creating the tester and working
out the kinks. So the most challenging part was definitely debugging the 
code. I ran into two major issues while finishing my project.

The first issue dealt with my hash functions for the linear probe and
double hash. They were close but not quite right which caused my program
to get stuck in a continuous loop. This took me a bit of thinking and using
the VS Code debugging tool. My second major issue was counting the average 
number of probes. My insert function was not correctly counting the number of
total probes, which is used in the method that calculates the average number
of probes.

## Compiling and Using

Usage: java HashtableTest <dataType> <loadFactor> [<debugLevel>]
       <dataSource>: 1 ==> random numbers
                     2 ==> date value as a long
                     3 ==> word list
       <loadFactor>: The ratio of objects to table size, 
                       denoted by alpha = n/m
       <debugLevel>: 0 ==> print summary of experiment

## Results 

Created a workable Hashtable with linear and double probing. After
I created the tester for the Hashtable to make sure the functionality
was all correct. I then altered the run-tests.sh file to create multiple
tests for the Hashtable. Below are the table results for each data type
using a 0.5 load factor.

--------------------------------------------------------------------------------
HashtableTest: Found a twin prime for table capacity: 95791
HashtableTest: Input: Integer    LoadFactor: 0.5
    Using Linear Probing
HashtableTest: size of hash table is 47896
    Inserted 47896 elements, of which 0 were duplicates
    Avg. no. of probes = 1.48

    Using Double Hashing
HastableTest: size of hash table is 47896
    Inserted 47896 elements, of which 0 were duplicates
    Avg. no. of probes = 1.38

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
HashtableTest: Found a twin prime for table capacity: 95791
HashtableTest: Input: Date    LoadFactor: 0.5
    Using Linear Probing
HashtableTest: size of hash table is 47896
    Inserted 47896 elements, of which 0 were duplicates
    Avg. no. of probes = 1.08

    Using Double Hashing
HastableTest: size of hash table is 47896
    Inserted 47896 elements, of which 0 were duplicates
    Avg. no. of probes = 1.12

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
HashtableTest: Found a twin prime for table capacity: 95791
HashtableTest: Input: Word-List    LoadFactor: 0.5
    Using Linear Probing
HashtableTest: size of hash table is 47896
    Inserted 1305930 elements, of which 1258034 were duplicates
    Avg. no. of probes = 1.60

    Using Double Hashing
HastableTest: size of hash table is 47896
    Inserted 1305930 elements, of which 1258034 were duplicates
    Avg. no. of probes = 1.39

--------------------------------------------------------------------------------

## Sources used

geeksforgeeks.org
stackoverflow.com
