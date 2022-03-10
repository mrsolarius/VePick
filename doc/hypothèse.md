# Hypothèse
Ce fichier répertorie nos hypothèses discutées en réunion et utilisées pour générer notre modèle conceptuel.

## [H1] Hypothèse 1
Cf. *[A14]* \
On considère qu'un **[abonné](glossaire.md#Abonné)** est automatiquement lié à son **[abonnement](glossaire.md#Abonnement)**.
Le renouvellement de l'**[abonnement](glossaire.md#Abonnement)** est automatique. Un abonné peut toutefois choisir de désactiver le renouvellement automatique.
Cela veut dire que l'on considèrera ici une date d'expiration de l'**[abonnement](glossaire.md#Abonnement)** directement dans l'**[abonné](glossaire.md#Abonné)**.
Si l'**[abonné](glossaire.md#Abonné)** a choisi de désactiver son renouvellement, une fois la date de son **[abonnement](glossaire.md#Abonnement)** expirée, l'**[abonné](glossaire.md#Abonné)** ne pourra plus utiliser son **[abonnement](glossaire.md#Abonnement)**.

## [H2] Hypothèse 2
Comme aucun exemple de numéro de **[vélo](glossaire.md#Vélo)** nous a été donné, on considère ici que le numéro de **[vélo](glossaire.md#Vélo)** est un entier naturel qui s'incrémente de 1 à chaque nouveau **[vélo](glossaire.md#Vélo)**.

## [H3] Hypothèse 3
Comme aucun exemple d'identifiant de **[bornette](glossaire.md#Bornette)** nous a été donné, on considère ici que l'identifiant de **[bornette](glossaire.md#Bornette)** est un entier naturel qui s'incrémente de 1 à chaque nouvelle **[bornette](glossaire.md#Bornette)**.
De plus comme on considère que une **[bornette](glossaire.md#Bornette)** appartient à une **[station](glossaire.md#Station)** alors la **[bornette](glossaire.md#Bornette)** sera aussi identifié par sa **[station](glossaire.md#Station)**.
Autrement dit on introduit ici une identification relative à la **[station](glossaire.md#Station)**.

## [H4] Hypothèse 4
On considère ici que le temps de trajet d'une **[location](glossaire.md#Location)** est exprimé en minutes, car cela permet éventuellement d'éffectuer une déduction de temps grace au **[crédit-temps](glossaire.md#Crédit-temps)** qui lui est clairement exprimé en minutes.

## [H5] Hypothèse 5
Cf. *[A19] [A21]* \
On considère qu'un **[usager](glossaire.md#Usager)** peut louer plusieurs **[vélos](glossaire.md#Vélo)** en reprenant une **[location](glossaire.md#Location)** à chaque vélo.
Cela veut dire que l'**[usager](glossaire.md#Usager)** peut prendre autant de **[location](glossaire.md#Location)** qu'il veut sans aucune limite.
Cela veut aussi dire qu'il devra effectuer autant de **[location](glossaire.md#Location)** que de **[vélo](glossaire.md#Vélo)** qu'il souhaite louer.

On considère ici qu'une interface graphique bien conçue pour l'**[usager](glossaire.md#Usager)** permet de sélectionner le nombre de **[vélo](glossaire.md#Vélo)** qu'il souhaite louer. 
Et générera dans le SI autant de **[locations](glossaire.md#Location)** que de **[vélos](glossaire.md#Vélo)** loués.

## [H6] Hypothèse 6
Cf. *[A4] [A9]*\
On suppose ici qu'un **[modèle](glossaire.md#Modèle)** de **[vélo](glossaire.md#Vélo)** dispose d'un nom qui fait office d'identifiant unique.

## [H7] Hypothèse 7
Cf. *[A2]*\
On utilise la cardinalité 2..\* car il est précisé dans le sujet qu'une **[station](glossaire.md#Station)** contient **plusieurs** **[bornettes](glossaire.md#Bornette)**, donc au moins deux.

## [H8] Hypothèse 8
Cf. *[A5]*\
On suppose ici qu'un **[vélo](glossaire.md#Vélo)** et une **[bornette](glossaire.md#Bornette)** pourront avoir un nouvel **[état](glossaire.md#État)** différent de OK ou HS : maintenance. Le sujet ne laisse pas de doute concernant la possibilité d'effectuer une maintenance sur un vélo, cependant nous avons décidé d'ajouter la possibilité de maintenance pour une **[bornette](glossaire.md#Bornette)** HS.

## [H9] Hypothèse 9
Cf. *[A14]*\
On suppose ici qu'un **[abonnement](glossaire.md#abonnement)** de un an est automatiquement renouvelé à la fin de l'année, toutefois les **[abonnés](glossaire.md#abonné)** pourront désactiver le renouvellement automatique s'ils ne souhaitent pas renouveler leurs **[abonnements](glossaire.md#abonnement)**.
