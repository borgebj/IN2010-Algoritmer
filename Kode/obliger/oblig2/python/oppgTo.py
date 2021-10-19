class oppgTo:

    def __init__(self, graph):
        self.graph = graph
        print("----[start oppgave 2]---")
        self.shortestPath("nm2255973", "nm0000460")
        self.shortestPath("nm0424060", "nm0000243")
        self.shortestPath("nm4689420", "nm0000365")
        self.shortestPath("nm0000288", "nm0001401")
        self.shortestPath("nm0031483", "nm0931324")

    # bruker liste innen queue(liste) for å representere veien
    def bfs(self, a, b):
        visited = []
        queue = [[a]]

        while queue:
            path = queue.pop(0)
            node = path[-1]

            if node not in visited:
                for neighbour in self.graph.neighbours(node):
                    result = list(path)
                    result.append(neighbour)
                    queue.append(result)

                    if neighbour == b:
                        return result
                visited.append(node)
        print("No path")
        return []

    # initierer BFS-metoden og skriver ut resultatet på en fin måte
    def shortestPath(self, idA, idB):
        actorA = self.graph.getActor(idA)
        actorB = self.graph.getActor(idB)
        res = self.bfs(actorA, actorB)
        forrige = res.pop(0)
        print("\n " + str(forrige))
        for actor in res:
            movie = self.graph.getMovieFromEdge(forrige, actor)
            print("===[", movie, "( " + str(movie.rating) + ")", "] ===>", actor)
            forrige = actor
