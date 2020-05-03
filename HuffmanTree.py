#
# Accepts a string to encode
# Decodes second string based on encoding of the first one
# Created by Yevhenii Ganusich
#


class Node:
    def __init__(self, c, freq):
        self.c = c
        self.freq = freq
        self.left = None
        self.right = None


class MinHeap:
    def __init__(self):
        self.data = []

    def empty(self):
        return self.size() == 0

    def size(self):
        return len(self.data)

    def print(self):
        for x in self.data:
            print(x.c + str(x.freq))

    def insert(self, val):
        self.data.append(val)
        self.__heapifyUp(len(self.data) - 1)

    def extractMin(self):
        temp = self.data[0]
        self.__swap(0, -1)
        self.data.remove(self.data[-1])
        self.__heapifyDown(0)
        return temp

    def __swap(self, i, j):
        self.data[i], self.data[j] = self.data[j], self.data[i]

    def __heapifyUp(self, idx):
        if idx > 0:
            parent = (idx - 1) // 2
            if self.data[parent].freq > self.data[idx].freq:
                self.__swap(parent, idx)
                self.__heapifyUp(parent)

    def __heapifyDown(self, idx):
        data = self.data
        left = 2 * idx + 1
        right = 2 * idx + 2
        mini = idx
        if left < len(data) and (data[left].freq < data[mini].freq):
            mini = left
        if right < len(data) and (data[right].freq < data[mini].freq):
            mini = right
        if mini is not idx:
            self.__swap(mini, idx)
            self.__heapifyDown(mini)


# This function creates Huffman tree
def encode(pq):
    root = None
    while pq.size() > 1:
        # Extract 2 minimum values
        node1 = pq.extractMin()
        node2 = pq.extractMin()
        newNode = Node("-", node1.freq + node2.freq)
        newNode.left = node1
        newNode.right = node2
        root = newNode
        pq.insert(newNode)
    return root


# This function decodes the encoded string
def decode(encodedStr, root):
    finalString = ""
    currentNode = root
    for number in encodedStr:
        if number == '0':
            currentNode = currentNode.left
            if currentNode.left is None and currentNode.right is None:
                finalString += currentNode.c
                currentNode = root
            else:
                continue
        else:
            currentNode = currentNode.right
            if currentNode.left is None and currentNode.right is None:
                finalString += currentNode.c
                currentNode = root
            else:
                continue
    print(finalString)
    return finalString


# This function builds dictionary based on Huffman tree
def buildDecodeDictionary(root, string, encodings):
    if root:
        if root.left is None and root.right is None and root.c != "-":
            encodings[root.c] = string
        else:
            buildDecodeDictionary(root.left, string + "0", encodings)
            buildDecodeDictionary(root.right, string + "1", encodings)


def printEncoding(string, dictionary):
    finalString = ""
    for letter in string:
        finalString += dictionary[letter]
    print(finalString)
    return finalString


if __name__ == '__main__':
    # Create a frequency map
    frequencyMap = {}
    # Record the string we need to encode
    toEncode = str(input())
    # Record the string we need to decode
    toDecode = str(input())
    # Update frequency map
    for letter in toEncode:
        if letter not in frequencyMap:
            frequencyMap[letter] = 1
        else:
            frequencyMap[letter] += 1
    # Sort the frequency map in alphabetical order to get consistent results
    frequencyMapSorted = sorted(frequencyMap.items(), key=lambda x: x[0])
    # Push the frequency map characters to the min-heap
    pq = MinHeap()
    for i in range(len(frequencyMapSorted)):
        pq.insert(Node(frequencyMapSorted[0][0], frequencyMapSorted[0][1]))
        frequencyMapSorted.pop(0)
    # Build Huffman Tree
    tree = encode(pq)
    encodings = {}
    # Build a dictionary based on Huffman tree
    buildDecodeDictionary(tree, "", encodings)
    # Print output 1
    printEncoding(toEncode, encodings)
    # Print output 2
    decode(toDecode, tree)
