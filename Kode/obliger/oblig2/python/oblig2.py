from obliger.oblig2.python.AdjacencyList import AdjacencyList
from obliger.oblig2.python.oppgEn import oppgEn
from obliger.oblig2.python.oppgTo import oppgTo


graph = AdjacencyList()


def oppgaveEn():
    oppgEn(graph)


def oppgaveTo():
    oppgaveEn()
    oppgTo(graph)


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
