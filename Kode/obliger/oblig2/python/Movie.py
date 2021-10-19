
class Movie:

    def __init__(self, id, title, rating, votes):
        self.id = id
        self.title = title
        self.rating = rating
        self.votes = votes
        self.actors = {}

    def addActor(self, id, actor):
        self.actors[id] = actor

    def getActors(self):
        return self.actors

    def getRating(self):
        return float(self.rating)

    def __str__(self):
        return str(self.title)+" ("+str(self.rating)+")"

    def __repr__(self):
        return str(self.title)
