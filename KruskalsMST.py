  
#
# Kruskals MST (takes input and returns the size of MST)
# Created by Yevhenii Ganusich
#


class Graph:

    def __init__(self, numOfNodes):
        self.size = numOfNodes
        self.towns = []
        self.graph = []

    def addEdge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    # Trace back to the root of both source and destination to see if they match
    def notInSameSet(self, source, destination, dictionary):
        temp = source
        # Keep looping until we hit the farthest parent
        while temp != dictionary[temp]:
            temp = dictionary[temp]

        fromRoot = temp

        # Keep looping until we hit the farthest parent
        temp = destination
        while temp != dictionary[temp]:
            temp = dictionary[temp]
        toRoot = temp

        # Return True if not the same, otherwise return False
        return toRoot != fromRoot

    # Union the source and destination if there is not loop yet
    def union(self, source, destination, dictionary):
        temp = source
        while temp != dictionary[temp]:
            temp = dictionary[temp]
        fromRoot = temp
        temp = destination
        while temp != dictionary[temp]:
            temp = dictionary[temp]
        toRoot = temp
        dictionary[toRoot] = fromRoot

    def Kruskals(self):
        total = 0
        mst = 0
        # dict will store the towns in ascending order
        dict = {}
        # Sort the graph by time required to plow the road
        self.graph = sorted(self.graph, key=lambda item: item[2])
        for town in self.towns:
            dict[town] = town
        while mst < len(self.towns) and len(self.graph):
            smallest = self.graph[0]
            if self.notInSameSet(smallest[0], smallest[1], dict):
                self.union(smallest[0], smallest[1], dict)
                mst += 1
                total += smallest[2]
            self.graph.pop(0)

        # Print the minimum amount of time for everyone to get reconnected
        print(total)


if __name__ == '__main__':
    # Read the number of towns
    numOfTowns = int(input())
    # Instantiate a graph of size numOfTowns
    graph = Graph(numOfTowns)
    # Get the towns
    for i in range(numOfTowns):
        newTown = str(input())
        graph.towns.append(newTown)
    # Read the number of roads between towns
    numOfRoads = int(input())
    for i in range(numOfRoads):
        string = str(input())
        list = string.split(',')
        source = str(list[0])
        destination = str(list[1].strip())
        weight = int(list[2].strip())
        # Add the road to the graph
        graph.addEdge(source, destination, weight)
    # Call Kruskals
    graph.Kruskals()