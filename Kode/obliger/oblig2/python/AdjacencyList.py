from collections import defaultdict


class AdjacencyList:
    actors = {}
    movies = {}

    def __init__(self):
        self.graph = {}
        self.edges = dict()

    def addNode(self, actor):
        if actor not in self.graph:
            self.graph[actor] = {}

    def addEdge(self, a, b, weight):
        if a not in self.graph: self.addNode(a)
        if b not in self.graph: self.addNode(b)

        self.graph[b][a] = weight
        self.graph[a][b] = weight

        self.edges[(a, b)] = weight
        self.edges[(b, a)] = weight

    # "getters"
    def getgraph(self):
        return self.graph

    def getActors(self):
        return self.actors

    def getActor(self, actor):
        if actor in self.actors:
            return self.actors[actor]

    def neighbours(self, actor):
        return self.graph[actor]

    def getMovies(self):
        return self.movies

    def getMovie(self, mid):
        return self.movies[mid]

    def getWeights(self):
        return self.edges

    def getWeight(self, a, b):
        return self.edges[a, b]

    # "Setters"
    def addMovie(self, mid, movie):
        self.movies[mid] = movie

    def addActor(self, aid, actor):
        self.actors[aid] = actor
        self.addNode(actor)

    def fillEdges(self):
        for m in self.movies:  # stor
            for a in self.movies[m].getActors():  # mindre
                for b in self.movies[m].getActors():  # mindre
                    actorOne = self.movies[m].getActors()[a]
                    actorTwo = self.movies[m].getActors()[b]
                    movie = self.movies[m]
                    if a != b:
                        self.addEdge(actorOne, actorTwo, movie)

    def getMovieFromEdge(self, a, b):
        return self.edges[(a, b)]

    def getEdges(self):
        return self.edges

    # print-metoder
    def printAll(self):
        print("Nodes")
        self.printNodes()
        print("Weights")
        self.printWeights()
        print("Counts")
        self.printCounts()

    def printWeights(self):
        for b in self.edges:
            print(b, end=" - ")
            print(self.edges[b])
        print("----------------------------------")

    def printNodes(self):
        for a in self.graph:
            print(a, end=" - ")
            print(self.graph[a])
        print("----------------------------------")

    def printCounts(self):
        print("Nodes:", len(self.graph))
        print("Edges:", int(len(self.edges) / 2))
