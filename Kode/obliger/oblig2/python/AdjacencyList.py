from collections import defaultdict


class AdjacencyList:

    def __init__(self):
        self.v = set()
        self.graph = defaultdict(set)
        self.w = dict()

    def addEdge(self, a, b, weight):
        self.v.add(a)
        self.v.add(b)

        self.graph[a].add(b)
        self.graph[b].add(a)

        self.w[(a, b)] = weight
        self.w[(b, a)] = weight

    def getgraph(self):
        return self.graph

    def addNode(self, actor):
        if actor not in self.graph or actor not in v:
            self.graph[actor] = set()
            self.v.add(actor)

    def print(self):
        for a in self.graph:
            print(a, end=" - ")
            print(self.graph[a],"\n")

        # for b in self.w:
        #     print(b, end=" - ")
        #     print(self.w[b])

        kanter = set()
        antkanter = 0
        for key in self.graph:
            for nabo in self.graph[key]:
                kanter.add(nabo)
                antkanter += 1

        print("Antall noder:", len(self.graph))
        print("Antall kanter:", len(kanter))
        print("Antall kanter:", antkanter/2)

        # self.w = ordbok med kanter (a, b) og vekten deres
        # self.graph = hver actor og deres
        # self.v = ???? ingen anelse
