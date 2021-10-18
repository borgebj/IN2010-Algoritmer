import random
from algoritmer.python_algoritmer.AdjacencyList import AdjacencyList
from collections import defaultdict
import graphviz


def fillRandom(graph):
    nodes = ["A", "B", "C", "D", "E", "F", "G"]
    weights = [1, 2, 3, 4, 5]
    for y in range(len(nodes)): graph.addNode(nodes[y])  # sørger for alfabetisk rekkefølge
    for x in range(5):
        one = random.choice(nodes)
        two = random.choice(nodes)
        weight = random.choice(weights)
        if one != two:
            if graph.weights:
                graph.addEdge(one, two, weight)
            else:
                graph.addEdge(one, two)


def drawDjikstra(graph, parents):
    dot = graphviz.Graph()
    for node in parents:
        u = parents[node]
        if u:
            dot.edge(node, u, label=str(graph[node][u]))
    dot.render("Dijkstra", format='svg')


# henter index til minste tuple + returnerer
def heappop(queue):
    indx = queue.index(min(queue))
    return queue.pop(indx)


# lambda: float vil si at dicten har default-verdi float
def Dijkstra(graph, start):
    queue = [(0, start)]
    dist = defaultdict(lambda: float('inf'))
    dist[start] = 0
    parents = {start: None}

    while queue:
        cost, node = heappop(queue)
        for nabo in graph[node]:
            c = cost + graph[node][nabo]

            if c < dist[nabo]:
                dist[nabo] = c
                queue.append((c, nabo))
                parents[nabo] = node
    return dist, parents


def printPath(parent, distances, dest):
    global vekt
    if distances[dest] == 0:
        print("Start:", dest)
        print("-------------------------")
        return

    printPath(parent, distances, parent[dest])
    vekt += distances[dest]
    print("===[", vekt, "] ===>", dest)


vekt = 0

def main():
    graph = AdjacencyList(weights=True)
    print("< Opprettet med graf med maks 10 kanter >")
    fillRandom(graph)
    graph.drawgraph()
    print("---------------")
    graph.printGraph()
    print("Dijkstra traversering for korteste vei")
    distances, parents = Dijkstra(graph.graph, input("Start: "))
    print("--------------------------------------------")
    print(dict(distances))
    drawDjikstra(graph.graph, parents)
    print("--------------------------------------------")
    slutt = input("Sluttnode: ")
    print("---------------")
    printPath(parents, distances, slutt)
    print("-------------------------")
    print("Slutt:", slutt)
    print("total vekt:", vekt)
    print("---------------")


main()
