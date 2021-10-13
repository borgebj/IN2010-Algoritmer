from obliger.oblig2.python.Actor import Actor
from obliger.oblig2.python.Movie import Movie
from obliger.oblig2.python.AdjacencyList import AdjacencyList
from collections import defaultdict

import time

graph = AdjacencyList()
movieList = []

actorCount = 5000
movieCount = 5000


def oppgaveEn():
    global graph

    def readActors(actorFile):
        global actorCount
        start = time.process_time()
        for actor in actorFile:
            # if actorCount <= 0:
            #     break
            # actorCount -= 1

            line = actor.strip().split("\t")
            a = Actor(line[0], line[1], line[2::])

            for movieId in line[2::]:
                for m in movieList:
                    if movieId == m.id:
                        m.addActor(a)

            graph.addNode(a)
        print("Actors:", float(time.process_time()-start),"s")

    def readMovies(movieFile):
        global movieCount
        start = time.process_time()
        for movie in movieFile:
            # if movieCount <= 0:
            #     break
            # movieCount -= 1

            id, title, rating, votes = movie.split("\t")
            m = Movie(id, title, rating, votes)

            # for key in graph.getgraph():
            #     if key.hasMovie(m.id):
            #         m.addActor(key)

            movieList.append(m)
        print("Movies:", float(time.process_time()-start),"s")

    def readFiles():
        movieFile = open("movies.tsv", encoding="utf-8")
        actorFile = open("actors.tsv", encoding="utf-8")
        readMovies(movieFile)
        readActors(actorFile)

    def fillGraph():
        start = time.process_time()
        for movie in movieList:
            for a in movie.getActors():
                for b in movie.getActors():
                    if a != b:
                        graph.addEdge(a, b, movie)
        print("Edges:", float(time.process_time()-start),"s")

    print("oppgave 1")
    readFiles()
    fillGraph()
    #graph.print()


def oppgaveTo():
    print("oppgave 2")


def oppgaveTre():
    print("oppgave 3")


def oppgaveFire():
    print("oppgave 4")


def velgOppgave(oppgave):
    if oppgave == "oppgave 1": oppgaveEn()
    elif oppgave == "oppgave 2": oppgaveTo()
    elif oppgave == "oppgave 3": oppgaveTre()
    elif oppgave == "oppgave 4": oppgaveFire()


def main():
    velgOppgave(input().lower())


main()

# Node = skuespiller
# to skuespillere har en kant mellom seg for hver film de har spilt i
# kanter merket med en film som har en rating