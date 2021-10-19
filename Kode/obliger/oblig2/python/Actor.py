
class Actor:

    def __init__(self, id, name, mids):
        self.id = id
        self.name = name
        self.mids = mids
        self.movies = {}

    def getMids(self):
        return self.mids

    def addMovie(self, id, movie):
        self.movies[id] = movie

    def __lt__(self, other):
        return True

    def __str__(self):
        return str(self.name)

    def __repr__(self):
        return "(A)"

