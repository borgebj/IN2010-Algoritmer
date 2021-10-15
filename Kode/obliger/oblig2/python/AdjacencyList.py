from collections import defaultdict

class AdjacencyList:

    actors = {}
    movies = {}
    edges = 0

    def __init__(self):
        self.graph = defaultdict(set)
        self.w = dict()

    #
    def addEdge(self, a, b, weight):
        self.graph[a].add(b)
        self.graph[b].add(a)

        self.w[(a, b)] = weight
        self.w[(b, a)] = weight
        self.edges += 1

    def getgraph(self):
        return self.graph

    def addNode(self, actor):
        if actor not in self.graph:
            self.graph[actor] = set()

    # nye # # # # # # # # # # # # # # # # # # # # # # # # # # #
    def addActor(self, aid, actor):
        self.actors[aid] = actor
        self.addNode(actor)

    def getActors(self):
        return self.actors

    def getActor(self, actor):
        if actor in self.actors:
            return self.actors[actor]

    def getNeighbours(self, actor):
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
        return self.w

    def getWeight(self, a, b):
        return self.w[a, b]

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
        return self.w[(a, b)]

    def getEdges(self):
        return self.w
    # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #

    def printWeights(self):
        print("-----------------------------------------------------------------")
        for b in self.w:
            print(b, end=" - ")
            print(self.w[b])
            print("-----------------------------------------------------------------")

    def printNodes(self):
        print("--------------------------------------------------------------------------------")
        for a in self.graph:
            print(a, end=" - ")
            print(self.graph[a])
            print("--------------------------------------------------------------------------------")

    def printCounts(self):
        antkanter = 0
        for actor in self.graph:
            neighbours = self.graph[actor]
            for n in neighbours:
                antkanter += 1
        print("----------------------------------")
        print("Nodes:", len(self.graph))
        print("Edges:", int(len(self.w)/2))
        print("----------------------------------")

        # self.w = ordbok med kanter (a, b) og vekten deres
        # self.graph = hver actor og deres naboer
