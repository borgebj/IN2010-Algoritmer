
# fra forelesning 28.09.21

from _collections import deque
from heapq import heappush, heappop

def test():
    list = [1, 2, 3]
    while list:
        print(list)
        list.pop()

test()

# DFS - Dybde-først søk - Rekursjon
def dfs_rec(G, s, visited, result):
    _, E, _ = G
    result.append(s)
    visited.add(s)
    for v in E[s]:
        if v not in visited:
            dfs_rec(G, v, visited, result)
    return result

# dfs_rec(G, 'A', set(), [])

# DFS - Dybde-først søk - Stack
def dfs(G, s):
    _, E, _ = G
    visited = set([s])
    stack = [s]
    result = []

    while stack:
        v = stack.pop()
        result.append(v)
        for u in E[v]:
            if u not in visited:
                visited.add(u)
                stack.append(u)
    return result

#dfs(G, 'A')


# BFS - Bredde-først søk
def bfs(G, s):
    _, E, _ = G
    visited = set([s])
    queue = deque([s])
    result = []

    while queue:
        v = deque.popleft(queue)
        result.append(v)
        for u in E[v]:
            if u not in visited:
                visited.add(u)
                queue.append(u)
    return result

# bfs(G, 'A')


# BFS - korteste sti
def bfs_shortest_paths_from(G, s):
    _, E, _ = G
    parents = {s : None}
    queue = deque([s])
    result = []

    while queue:
        v = deque.popleft(queue)
        result.append(v)
        for u in E[v]:
            if u not in parents:
                parents[u] = v
                queue.append(u)
    return parents

#BFS - korteste sti fra en node til alle andre
def bfs_all_shortest_paths(G, s):
    V, _, _ = G
    parents = bfs_shortest_paths_from(G, s)
    paths = []

    for v in V:
        path = []
        while v:
            path.append(v)
            v = parents[v]
        paths.append(path[::-1])
    return paths

#sorted(bfs_all_shortest_paths(G, 'A'))

#BFS - korteste sti mellom to spesifikke noder
def bfs_shortest_path_between(G, s, t):
    parents = bfs_shortest_paths_from(G, s)
    v = t
    path = []

    if t not in parents:
        return path

    while v:
        path.append(v)
        v = parents[v]
    return path[::-1]

#bfs_shortest_path_between(G, 'A', 'G')

# DJikstra

def dijkstra(G, s):
    V, E, w = G
    Q = [(0, s)]
    D = defaultdict(lambda: float('inf'))
    D[s] = 0

    while Q:
        cost, v = heappop(Q)
        for u in E[v]:
            c = cost + w[(v, u)]
            if c < D[u]:
                D[u] = c
                heappush(Q, (c, u))

    return D