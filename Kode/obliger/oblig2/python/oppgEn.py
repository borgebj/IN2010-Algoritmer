from obliger.oblig2.python.Actor import Actor
from obliger.oblig2.python.Movie import Movie
import time


class oppgEn:

    def __init__(self, graph):
        self.graph = graph
        print("----[start oppgave 1]---")
        self.readFiles()
        self.fillGraph()

    def readMovies(self, movieFile):
        movieCount = 5000
        start = time.process_time()
        for movie in movieFile:
            # if movieCount == 0:
            #     break
            # movieCount -= 1

            mid, title, rating, votes = movie.split("\t")
            m = Movie(mid, title, rating, votes)
            self.graph.addMovie(mid, m)

        print("Movies:", float(time.process_time() - start), "s")

    def readActors(self, actorFile):
        actorCount = 5000
        start = time.process_time()
        for actor in actorFile:
            # if actorCount == 0:
            #     break
            # actorCount -= 1


            line = actor.strip().split("\t")
            a = Actor(line[0], line[1], line[2::])

            # fyller movies sine actors, og actors sine movies
            for mid in line[2::]:
                if mid in self.graph.getMovies():
                    a.addMovie(mid, self.graph.getMovie(mid))
                    self.graph.getMovie(mid).addActor(line[0], a)
            self.graph.addActor(line[0], a)

        print("Actors:", float(time.process_time() - start), "s")

    def readFiles(self):
        movieFile = open("movies.tsv", encoding="utf-8")
        actorFile = open("actors.tsv", encoding="utf-8")
        self.readMovies(movieFile)
        self.readActors(actorFile)

    def fillGraph(self):
        start = time.process_time()
        self.graph.fillEdges()
        print("Edges:", float(time.process_time() - start), "s")
        self.graph.printCounts()

