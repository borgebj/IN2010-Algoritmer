import random
from algoritmer.python_algoritmer.AdjacencyList import AdjacencyList


def fillRandom(graph):
    nodes = ["A", "B", "C", "D", "E", "F", "G"]
    #nodes = [1, 2, 3, 4, 5, 6, 7, 8]
    for y in range(len(nodes)): graph.addNode(nodes[y]) # sørger for alfabetisk rekkefølge
    for x in range(10):
        one = random.choice(nodes)
        two = random.choice(nodes)
        if one != two: graph.addEdge(one, two)
    graph.printGraph()


# Hoved-funksjonen for denne filen #
def DFS(graph, startnode):
    visited = set(startnode)
    stack = [startnode]
    result = []

    while stack:
        node = stack.pop()
        result.append(node)
        for nabo in graph[node]:
            if nabo not in visited:
                visited.add(nabo)
                stack.append(nabo)

    return result


def main():
    graph = AdjacencyList()
    fillRandom(graph)
    graph.drawgraph()
    print(
        DFS(graph.getGraphh(), input("Startnode:\n> ")))


main()