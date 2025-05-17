# Experiements with Hashing

* Author: Karter Melad

## Overview

This project is an implementation of a Hashtable with open addressing. 
We can use this project to view the difference in probe counts when the 
load factor varies.

## Compiling and Using

Usage: java HashtableTest <dataType> <loadFactor> [<debugLevel>]
       <dataSource>: 1 ==> random numbers
                     2 ==> date value as a long
                     3 ==> word list
       <loadFactor>: The ratio of objects to table size, 
                       denoted by alpha = n/m
       <debugLevel>: 0 ==> print summary of experiment
