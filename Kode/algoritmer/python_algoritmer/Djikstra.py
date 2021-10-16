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

def Djikstra(graph, start, slutt):



def main():
    graph = AdjacencyList(weights=False)
    print("< Opprettet med graf med maks 10 kanter >")
    fillRandom(graph)
    graph.drawgraph()
    print("---------------")
    graph.printGraph()
    print("Djikstra traversering for korteste vei")
    print(Djikstra(graph, input("Start: ")), input("Slutt: "))
    print("--------------------------------------------")

main()
