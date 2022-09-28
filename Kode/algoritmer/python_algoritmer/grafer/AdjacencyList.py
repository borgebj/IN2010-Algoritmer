import graphviz

"""
Dynamisk Adjacency-List for både vektet og uvektet graf
"""


class AdjacencyList:
    graph = {}        # grafen {"nøkkel": {nabo: vekt}, "nøkkel": {nabo: vekt} }
    edges = dict()    # kanter {"(a, b)": vekt, "(c, d)": vekt }
    edgeCount = 0

    def __init__(self, weights):
        self.weights = weights

    def addNode(self, node):
        self.graph[node] = {}

    # tar hensyn til både uvektet og vektet graf
    def addEdge(self, a, b, *weight):
        if self.weights: weight = weight[0]

        # lager tom node
        if a not in self.graph: self.addNode(a)
        if b not in self.graph: self.addNode(b)

        # legger til kanter med vekt
        self.graph[a][b] = weight
        self.graph[b][a] = weightn

        # legger til kante-par og vekter i egen ordbok
        self.edges[(a, b)] = weight
        self.edges[(b, a)] = weight

    def sizeEdges(self):
        for node in self.graph:
            self.edgeCount += len(self.graph[node]) / 2
        return int(self.edgeCount)

    def printGraph(self):
        for key in self.graph:
            if len(self.graph[key]) == 0: self.graph[key] = []
            print(key, "-", self.graph[key])
        print("----------------------")
        print("Nodes:", len(self.graph))
        print("Edges:", self.sizeEdges())
        print("Edges:", self.edges)
        print("----------------------")

    def getGraphh(self):
        return self.edges

    def getData(self):
        return self.edges, self.graph



    # region Graphviz - uten vekter
    # metode som tegner grafen som et bilde
    def drawgraph(self):
        dot = graphviz.Graph()
        seen_edges = set()
        for v in self.graph:
            dot.node(v)
            for u in self.graph[v]:
                if (u, v) in seen_edges:
                    continue
                seen_edges.add((v, u))
                if self.weights: dot.edge(v, u, label=str(self.graph[v][u]))
                else: dot.edge(v, u)
        dot.render('graph', format='svg')

    # endregion

    """ Traverseringsmetoder for grafen """
    # region BFS
    # fra BredthFirstSearch.py
    def BFS(self, startnode):
        visited = [startnode]
        queue = [startnode]
        path = []

        while queue:
            node = queue.pop(0)
            path.append(node)
            for nabo in self.graph[node]:
                if nabo not in visited:
                    visited.append(nabo)
                    queue.append(nabo)
        return path

    def BFS_shortest_path(self, start, slutt):
        visited = []
        queue = [[start]]

        while queue:
            sti = queue.pop(0)
            node = sti[-1]

            if node not in visited:
                for nabo in self.graph[node]:
                    ny_sti = list(sti)
                    ny_sti.append(nabo)
                    queue.append(ny_sti)

                    if nabo == slutt:
                        return ny_sti
                visited.append(node)
        print("Ingen sti")
        return []
    # endregion

    # region DFS
    # fra DepthFirstSearch.py
    def DFS(self, startnode):
        visited = set(startnode)
        stack = [startnode]
        result = []

        while stack:
            node = stack.pop()
            result.append(node)
            for nabo in self.graph[node]:
                print("Nabo til",node, nabo)
                if nabo not in visited:
                    visited.add(nabo)
                    stack.append(nabo)
        return result

    # DFS - rekursjon
    def DFS_rec(self, node, visited=[]):
        visited += node
        for nabo in self.graph[node]:
            if nabo not in visited:
                visited = self.DFS_rec(nabo, visited)
        return visited

    # endregion
    """"""""""""""""""""""""""""""""""""""
