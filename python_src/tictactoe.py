JOUEURS = 'xo'

class Etat(object):
    """ possibilites : '-', 'x', 'o' """
    grille = '---------'
    tour = 'x'

    def __init__(self, grille):
        if grille is not None:
            self.grille = grille
        super(Etat, self).__init__()

    def __str__(self):
        if self.fin_du_match:
            apendix = "%s gagne!" % self.gagnant()
        else:
            apendix = "prochain a jouer : %s" % self.tour.__str__()
        return "%s prochain a jouer : %s" % (self.grille.__str__(), apendix)

    def prochains_etat(self):
        """ retuorne une liste des prochaines etats"""
        etats = []
        for i, case in enumerate(self.grille):
            if case == '-':
                nouv_grille = self.tour.join(self.grille.split('-',1))
                nouv_etat = Etat(nouv_grille)
                tour = ''.join(JOUEURS.split(self.tour))
                nouv_etat.tour = tour
                etats.append(nouv_etat)
        return etats

    def fin_du_match(self):
        if '-' not in self.grille:
            return True
        for row in range(3):
            if self.grille[row] == self.grille[row+1] == self.grille[row+2] != '-':
                return True
        for col in range(3):
            if self.grille[col] == self.grille[col+3] == self.grille[col+6] != '-':
                return True
        if (self.grille[0] == self.grille[4] == self.grille[8] != '-'):
            return True
        if (self.grille[2] == self.grille[4] == self.grille[6] != '-'):
            return True

        return False

    def gagnant(self):
        if not self.fin_du_match():
            return None
        return ''.join(JOUEURS.split(self.tour))


class Noeud(object):
    def __init__(self, etat):
        self.etat = etat
        self.enfants = []

    def ajouter(self, etat):
        self.enfants.append(etat)


def sous_arbre_jusqua_complet(noeud):
    """ rempli le sous-arbre des etats jusqu'a fin du match """
    if noeud.etat.fin_du_match():
        return
    for pe in noeud.etat.prochains_etat():
        n = Noeud(pe)
        noeud.enfants.append(n)
    for enfant in noeud.enfants:
        sous_arbre_jusqua_complet(enfant)

def game():
    etat_init = Etat(None)
    racine = Noeud(etat_init)
    sous_arbre_jusqua_complet(racine)

    n = racine
    while len(n.enfants):
        print n.enfants[0].etat
        n = n.enfants[0]
    

if __name__ == "__main__":
    game()
