import graphviz


class AdjacencyList:
    graph = {}

    def addNode(self, node):
        self.graph[node] = set()

    def addEdge(self, a, b):
        if a not in self.graph: self.addNode(a)
        if b not in self.graph: self.addNode(b)
        self.graph[a].add(b)
        self.graph[b].add(a)

    def printGraph(self):
        for key in self.graph:
            if len(self.graph[key]) == 0: self.graph[key] = {}
            print(key, "-", self.graph[key])
        print("----------------------")

    def getGraphh(self):
        return self.graph

    def drawgraph(self):
        dot = graphviz.Graph()
        seen_edges = set()

        for v in self.graph:
            dot.node(v)

            for u in self.graph[v]:
                if (u, v) in seen_edges:
                    continue
                seen_edges.add((v, u))
                dot.edge(v, u)

        dot.render('graph', format='svg')

    # BFS-start
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
    # BFS-end