import sys
import time



class oppgFire:

    def __init__(self, graphclass):
        self.graphclass = graphclass
        self.graph = graphclass.graph
        self.findComponents()
        sys.setrecursionlimit(2000)

    def comp_utility(self, temp, node, visited):
        visited.add(node)
        temp.add(node)
        queue = [node]

        while queue:
            n = queue.pop(0)
            for nabo in self.graph[n]:
                if nabo not in visited:
                    temp.add(nabo)
                    visited.add(nabo)
        return temp

    # Method to retrieve connected components
    # in an undirected graph
    def connectedComponents(self):
        visited = set()
        con_comp = []

        for node in self.graph:
            if node not in visited:
                temp = set()
                clist = self.comp_utility(temp, node, visited)
                con_comp.append(clist)
        return con_comp


    def printCount(self, cc):
        unique = {}
        for component in cc:
            length = len((set(component)))
            if length in unique:unique[length] += 1
            else:unique[length] = 1
        for key in sorted(unique):
            print("There are", unique[key], "components of size", key)

    def findComponents(self):
        print("---------------------------------------------------")
        start = time.process_time()
        cc = self.connectedComponents()
        self.printCount(cc)
        print("Komponenter:", float(time.process_time() - start), "s")
        print("---------------------------------------------------")
