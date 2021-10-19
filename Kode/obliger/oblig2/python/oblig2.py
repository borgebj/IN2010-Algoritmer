from obliger.oblig2.python.AdjacencyList import AdjacencyList
from obliger.oblig2.python.oppgEn import oppgEn
from obliger.oblig2.python.oppgTo import oppgTo
from obliger.oblig2.python.oppgTre import oppgTre
from obliger.oblig2.python.oppgFire import oppgFire


graph = AdjacencyList()


def oppgaveEn():
    oppgEn(graph)


def oppgaveTo():
    oppgaveEn()
    oppgTo(graph)


def oppgaveTre():
    oppgaveEn()
    oppgTre(graph)


def oppgaveFire():
    oppgaveEn()
    oppgFire(graph)


def velgOppgave(oppgave):
    if oppgave == "oppgave 1": oppgaveEn()
    elif oppgave == "oppgave 2": oppgaveTo()
    elif oppgave == "oppgave 3": oppgaveTre()
    elif oppgave == "oppgave 4": oppgaveFire()


def main():
    velgOppgave(input().lower())


main()
