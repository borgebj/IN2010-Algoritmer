import random
from algoritmer.python_algoritmer.AdjacencyList import AdjacencyList


def fillRandom(graph):
    nodes = ["A", "B", "C", "D", "E", "F", "G"]
    #nodes = [1, 2, 3, 4, 5, 6, 7, 8]
    for y in range(len(nodes)): graph.addNode(nodes[y]) # sørger for alfabetisk rekkefølge
    for x in range(5):
        one = random.choice(nodes)
        two = random.choice(nodes)
        if one != two: graph.addEdge(one, two)
    graph.printGraph()


# Hoved-funksjonen for denne filen #
def BFS(graph, startnode):
    visited = [startnode]
    queue = [startnode]
    path = []

    while queue:
        node = queue.pop(0)
        path.append(node)
        for nabo in graph[node]:
            if nabo not in visited:
                visited.append(nabo)
                queue.append(nabo)
    return path


def main():
    graph = AdjacencyList()
    fillRandom(graph)
    graph.drawgraph()
    print("BFS traversering")
    print(BFS(graph.graph, input("Startsnode: ")))
    print("--------------------------------------------")
    print("BFS traversering for korteste vei")
    print(graph.BFS_shortest_path(input("Start: "), input("Slutt:\n> ")))


main()