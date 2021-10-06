def oppgaveEn():
    print("oppgave 1")

    actors = []
    movies = []

    movieFile = open(input("Movies-fil: "))
    actorFile = open(input("Actors-fil: "))

    for actor in actorFile:
        id, navn, filmer = actor.split("  ")

def oppgaveTo():
    print("oppgave 2")

def oppgaveTre():
    print("oppgave 3")

def oppgaveFire():
    print("oppgave 4")


def velgOppgave(nr):
    if nr == "1": oppgaveEn()
    elif nr == "2": oppgaveTo()
    elif nr == "3": oppgaveTre()
    elif nr == "4": oppgaveFire()


from collections import defaultdict

def buildgraph(lines):
    V = set()
    E = defaultdict(set)
    w = dict()

    for line in lines.splitlines():
        v, u, weight = line.strip().split()

        V.add(v)
        V.add(u)

        E[v].add(u)
        E[u].add(v)

        w[(v, u)] = int(weight)
        w[(u, v)] = int(weight)

    return w

def main():
    g = buildgraph("A B 13\nA C 6\nB C 7\nB D 1\nC D 14")
    print(g)


main()

# Node = skuespiller
# to skuespillere har en kant mellom seg for hver film de har spilt i
# kanter merket med en film som har en rating