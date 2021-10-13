from obliger.oblig2.python.Actor import Actor


class Movie:

    def __init__(self, id, title, rating, votes):
        self.id = id
        self.title = title
        self.rating = rating
        self.votes = votes
        self.actors = []

    def actorPlayed(self, actor):
        return actor in self.actors

    def addActor(self, actor):
        self.actors.append(actor)

    def getActors(self):
        return self.actors

    def __str__(self):
        return str(self.title)

    def __repr__(self):
        return str("|"+self.title+"|")
