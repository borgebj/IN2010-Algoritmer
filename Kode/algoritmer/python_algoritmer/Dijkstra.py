import random
from algoritmer.python_algoritmer.AdjacencyList import AdjacencyList
from collections import defaultdict
import graphviz


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

def main():
    graph = AdjacencyList(weights=True)
    print("< Opprettet med graf med maks 10 kanter >")
    fillRandom(graph)
    graph.drawgraph()
    print("---------------")
    graph.printGraph()
    print("Djikstra traversering for korteste vei")
    distances, parents = Dijkstra(graph.graph, input("Start: "))
    print("--------------------------------------------")
    print("Printer sti ... ")
    print(dict(distances))
    dot = graphviz.Graph()
    for node in parents:
        u = parents[node]
        if u:
            dot.edge(node, u, label=str(graph.graph[node][u]))
    dot.render("Dijkstra", format='svg')
    print("--------------------------------------------")


main()
