
class Movie:
    def __init__(self, id, tittel, rating, stemmer):
        self.id = id
        self.tittel = tittel
        self.rating = rating
        self.stemmer = stemmer

    def __str__(self):
        print(self.tittel, self.rating)