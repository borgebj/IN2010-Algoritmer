import random
from algoritmer.python_algoritmer.AdjacencyList import AdjacencyList


def fillRandom(graph):
    nodes = ["A", "B", "C", "D", "E", "F", "G"]
    weights = [1, 2, 3, 4, 5]
    for y in range(len(nodes)): graph.addNode(nodes[y])  # sørger for alfabetisk rekkefølge
    for x in range(10):
        one = random.choice(nodes)
        two = random.choice(nodes)
        weight = random.choice(weights)
        if one != two:
            if graph.weights: graph.addEdge(one, two, weight)
            else: graph.addEdge(one, two)


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


def DFS_rec(graph, node, visited=[]):
    visited += node
    for nabo in graph[node]:
        if nabo not in visited:
            visited = DFS_rec(graph, nabo, visited)
    return visited


def main():
    graph = AdjacencyList(weights=False)
    print("< Opprettet med graf med maks 10 kanter >")
    fillRandom(graph)
    graph.drawgraph()
    print("---------------")
    graph.printGraph()
    print("DFS traversering")
    print(graph.DFS(input("Startsnode: ")))
    print("--------------------------------------------")
    print("DFS traversering rekursjon")
    print(graph.DFS_rec(input("Startsnode: ")))


main()
