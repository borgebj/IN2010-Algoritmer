

class Actor:

    def __init__(self, id, name, movies):
        self.id = id
        self.name = name
        self.movies = movies

    def hasMovie(self, movie):
        return movie in self.movies

    def __str__(self):
        return str(self.name)

    def __repr__(self):
        return str(self.name)

