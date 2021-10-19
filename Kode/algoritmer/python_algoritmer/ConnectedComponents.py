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
            if graph.weights:
                graph.addEdge(one, two, weight)
            else:
                graph.addEdge(one, two)


def comp_utility(graph, temp, node, visited):
    visited.append(node)
    temp.append(node)
    queue = [node]

    while queue:
        n = queue.pop(0)
        for nabo in graph[n]:
            if nabo not in visited:
                temp.append(nabo)
                visited.append(nabo)
    return temp


def con_comp(graph):
    visited = []
    con_comp = []

    for node in graph:
        if node not in visited:
            temp = []
            clist = comp_utility(graph, temp, node, visited)
            con_comp.append(clist)
    return con_comp


def printCount(cc):
    unique = {}
    for component in cc:
        length = len((set(component)))
        if length in unique:
            unique[length] += 1
        else:
            unique[length] = 1
    for key in sorted(unique):
        print("There are", unique[key], "components of size", key)


def main():
    graph = AdjacencyList(weights=True)

    # graf-del
    print("< Opprettet med graf med maks 10 kanter >")
    fillRandom(graph)
    graph.drawgraph()
    print("---------------")

    # Komponent-del
    cc = con_comp(graph.graph)
    print(cc)
    printCount(cc)


main()
