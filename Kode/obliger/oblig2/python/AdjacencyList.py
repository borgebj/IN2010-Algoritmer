from collections import defaultdict


class AdjacencyList:

    actors = {}
    movies = {}

    def __init__(self):
        #self.graph = defaultdict(set)
        self.graph = {}
        self.edges= dict()

        # self.edges = ordbok med kanter (a, b) og vekten deres
        # self.graph = hver actor og deres naboer

    def addNode(self, actor):
        if actor not in self.graph:
            #self.graph[actor] = set()
            self.graph[actor] = {}

    def addEdge(self, a, b, weight):
        if a not in self.graph: self.addNode(a)
        if b not in self.graph: self.addNode(b)

        if a not in self.graph[a]: self.graph[b][a] = weight
        if b not in self.graph[b]: self.graph[a][b] = weight
        if (a, b) not in self.edges: self.edges[(a, b)] = weight

        # self.graph[a].add(b)
        # self.graph[b].add(a)
        #
        # self.edges[(a, b)] = weight
        # self.edges[(b, a)] = weight

    def getgraph(self):
        return self.graph

    # nye # # # # # # # # # # # # # # # # # # # # # # # # # # #
    def addActor(self, aid, actor):
        self.actors[aid] = actor
        self.addNode(actor)

    def getActors(self):
        return self.actors

    def getActor(self, actor):
        if actor in self.actors:
            return self.actors[actor]

    def neighbours(self, actor):
        return self.graph[actor]

    def addMovie(self, mid, movie):
        self.movies[mid] = movie

    def getMovie(self, mid):
        return self.movies[mid]

    def getMovie(self, movie):
        return self.movies[movie]

    def getMovies(self):
        return self.movies

    def getWeights(self):
        return self.edges

    def getWeight(self, a, b):
        return self.edges[a, b]

    def fillEdges(self):
        for m in self.movies: # stor
            for a in self.movies[m].getActors(): # mindre
                for b in self.movies[m].getActors(): # mindre
                    actorOne = self.movies[m].getActors()[a]
                    actorTwo = self.movies[m].getActors()[b]
                    movie = self.movies[m]
                    if a != b:
                        self.addEdge(actorOne, actorTwo, movie)

    def getMovieFromEdge(self, a, b):
        return self.edges[(a, b)]

    def getEdges(self):
        return self.edges
    # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #

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
        print("Edges:", int(len(self.edges)/2))
        print("----------------------------------")
