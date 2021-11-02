# -----------------------------------------------------------
# Assignment 9 CSCE 3193 Programming Paradigms
#
# Robert Johnson
# rcj009@uark.edu
# 010796992
# -----------------------------------------------------------

import sys
import re
import operator

if len(sys.argv) < 3:
	if len(sys.argv) < 2:
		print('Missing the argument: story')
	print('Missing the argument: skip-words')
	print('Example: assignment9.py <story> <skip-words>')
	exit(0)

with open(sys.argv[1], 'r') as storyFile:
	story = [re.sub(r'\n|\t|\.|\?|!|,|;|:|\'|"', '', s.lower()).strip() for s in storyFile.readlines()]

with open(sys.argv[2], 'r') as skipFile:
	skipWords = skipFile.readline().split(',')

wordList = []
for line in story:
	if not line:
		continue
	wordList.extend([word for word in line.split(' ') if word and word not in skipWords])

wordPair = { }
for i in range(len(wordList) - 1):
	key = '{} {}'.format(wordList[i], wordList[i + 1])
	wordPair[key] = wordPair[key] + 1 if key in wordPair else 1
    
print('Story file name:' , storyFile.name)
print('Skip word file name:' , skipFile.name)
print('Skip words:' , skipWords)
print('The five most frequently occuring word pairs are:')
wordPair = sorted(wordPair.items(), key=operator.itemgetter(1), reverse=True)
for i in range(5):
	print(wordPair[i])