from obliger.oblig2.python.Actor import Actor
from obliger.oblig2.python.Movie import Movie
from obliger.oblig2.python.AdjacencyList import AdjacencyList
import time


graph = AdjacencyList()

actorCount = 200
movieCount = 200


def oppgaveEn():
    global graph

    def readMovies(movieFile):
        global movieCount
        start = time.process_time()
        for movie in movieFile: # 98 000
            # if movieCount <= 0:
            #     break
            # movieCount -= 1

            mid, title, rating, votes = movie.split("\t")
            m = Movie(mid, title, rating, votes)
            graph.addMovie(mid, m)

        print("Movies:", float(time.process_time()-start),"s")

    def readActors(actorFile):
        global actorCount
        start = time.process_time()
        for actor in actorFile:
            # if actorCount <= 0:
            #     break
            # actorCount -= 1

            line = actor.strip().split("\t")
            a = Actor(line[0], line[1], line[2::])

            # fyller movies sine actors, og actors sine movies
            for mid in line[2::]:
                if mid in graph.getMovies():
                    a.addMovie(mid, graph.getMovie(mid))
                    graph.getMovie(mid).addActor(line[0], a)
            graph.addActor(line[0], a)


        print("Actors:", float(time.process_time()-start),"s")

    def readFiles():
        movieFile = open("movies.tsv", encoding="utf-8")
        actorFile = open("actors.tsv", encoding="utf-8")
        readMovies(movieFile)
        readActors(actorFile)
        fillGraph()

    def fillGraph():
        start = time.process_time()
        graph.fillEdges()
        print("Edges:", float(time.process_time()-start),"s")
        #graph.printWeights()
        #graph.printNodes()
        graph.printCounts()

    print("oppgave 1")
    readFiles()
    # fillGraph()
    # graph.print()


def oppgaveTo():
    # bruker liste innen queue for å representere veien
    def bfs(a, b):
        visited = []
        queue = [[a]]

        while queue:
            path = queue.pop(0)
            node = path[-1]

            if node not in visited:
                for neighbour in graph.getNeighbours(node):
                    new_path = list(path)
                    new_path.append(neighbour)
                    queue.append(new_path)

                    if neighbour == b:
                        new_path.remove(a)
                        return new_path
                visited.append(node)
        print("No path")
        return

    #
    def shortestPath(idA, idB):
        actorA = graph.getActor(idA)
        actorB = graph.getActor(idB)
        res = bfs(actorA, actorB)
        forrige = actorA
        print("\n",actorA)
        for actor in res:
            movie = graph.getMovieFromEdge(forrige, actor)
            print("===[", movie, "("+str(movie.rating)+")", "] ===>", actor)
            forrige = actor

    print("oppgave 2")
    oppgaveEn()
    shortestPath("nm2255973", "nm0000460")
    shortestPath("nm0424060", "nm0000243")
    shortestPath("nm4689420", "nm0000365")
    shortestPath("nm0000288", "nm0001401")
    shortestPath("nm0031483", "nm0931324")


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