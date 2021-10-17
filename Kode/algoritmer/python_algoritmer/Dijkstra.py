import random
from algoritmer.python_algoritmer.AdjacencyList import AdjacencyList
from collections import defaultdict
import collections


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


def heappop(queue):
    if not queue: return
    minste = min(queue)
    queue.remove(minste)
    return minste

# lambda: float vil si at dicten har default-verdi float
def Dijkstra(graph, start):
    queue = [(0, start)]
    dist = defaultdict(lambda: float('inf'))
    dist[start] = 0

    print("Distanser:", dist)

    while queue:
        cost, node = heappop(queue)
        for nabo in graph[node]:
            c = cost + graph[node][nabo]
            print("Nabo", nabo, "kost", c)
            if c < dist[nabo]:
                dist[nabo] = c
                queue.append((c, nabo))
    return dist


def main():
    graph = AdjacencyList(weights=True)
    print("< Opprettet med graf med maks 10 kanter >")
    fillRandom(graph)
    graph.drawgraph()
    print("---------------")
    graph.printGraph()
    print("Djikstra traversering for korteste vei")
    distances = Dijkstra(graph.graph, input("Start: "))
    print("--------------------------------------------")
    for key in distances:
        print(key+":", distances[key])
    print(dict(distances))
    print("--------------------------------------------")


main()
