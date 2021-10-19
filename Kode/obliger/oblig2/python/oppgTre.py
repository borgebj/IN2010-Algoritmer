import time
from collections import defaultdict
from heapq import heappush, _heappop_max, heappop, _heapify_max


class oppgTre:

    def __init__(self, graphclass):
        self.graphclass = graphclass
        self.graph = graphclass.graph
        self.vekt = 0.0
        print("----[start oppgave 3]---")
        self.chillestPath("nm2255973", "nm0000460")
        self.chillestPath("nm0424060", "nm0000243")
        self.chillestPath("nm4689420", "nm0000365")
        self.chillestPath("nm0000288", "nm0001401")
        self.chillestPath("nm0031483", "nm0931324")

    # lambda: 0 vil si at dicten har default-verdi 0 - 0 for å finne høyeste
    def DijkstraHeaviest(self, graph, s, dest):
        visited = [s]
        queue = [(0, s)]
        distances = defaultdict(lambda: 0)
        parents = {s: None}

        while queue:
            _heapify_max(queue)
            cost, highest = _heappop_max(queue)

            for nabo in graph[highest]:
                c = graph[nabo][highest].getRating()
                if c > distances[nabo] and nabo not in visited:
                    visited.append(nabo)
                    distances[nabo] = c
                    heappush(queue, (c, nabo))
                    parents[nabo] = highest

                    # stopper om destinasjonen er funnet (ellers tar funksjonen altfor lang tid)
                    if nabo == dest: return parents, distances

        return parents, distances

    def printPath(self, parent, distances, dest, graph):
        if parent[dest] == 0:
            print("-------------------------")
            print("Start:", dest)
            return
        self.printPath(parent, distances, distances[dest], graph)
        self.vekt += (10-graph[dest][distances[dest]].getRating())
        print("===[", graph[dest][distances[dest]], "] ===>", dest)

    # initierer Dijkstra og printer vha hjelpefunksjon ^
    def chillestPath(self, idA, idB):
        start = time.process_time()
        self.vekt = 0
        actorA = self.graphclass.getActor(idA)
        actorB = self.graphclass.getActor(idB)

        distances, parents = self.DijkstraHeaviest(self.graph, actorA, actorB)
        self.printPath(parents, distances, actorB, self.graph)
        print("Total weight:", round(self.vekt, 2))
        print("-------------------------")
        print("ChillestPath:", float(time.process_time() - start), "s\n")
