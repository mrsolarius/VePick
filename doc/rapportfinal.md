# Rapport Projet VéPick
Code sources disponibles sur [Github](https://github.com/mrsolarius/ProjetBDD)

Membres du projet :
* *Adam MOUSSOLNA*
* *Julien TURC*
* *Louis VOLAT*
* *Lucas ZAETTA*
* *Hubert ZODJIHOUE*

```

@todo indiquer les modification apporter au modèle conceptuel/relationelle/mappingJPA
@todo indiquer l'avancement du projet
@todo présenter nos scénarios de test
@todo présenter notre peuplement de données et nos testes
@todo discuter de nos choix de modélisation conceptuelle
@todo retour critique sur notre travail
```

## Objectifs du projet
 Le but du projet était de développer un système de gestion de vélos partagés similaire à ceux utilisés par Velo'v à Lyon ou
 Vélib à Paris. Ce système devait permettre à n'importe quel usager de louer simplement un vélo afin de se déplacer
dans Salem et Groville. Le système doit être simple, rapide, efficace et accessible à tous.

Pour réaliser cette application, nous avons utilisé Java et le framework JPA, ainsi que le moteur de base de données 
MariaDB pour le développement. En effet, la mise en production avec Oracle posait des problèmes au niveau de la 
connection ainsi qu'au niveau de l'identification avec JPA. Afin de nous simplifier la tâche, nous
avons développé notre interface homme-machine directement en console.
```
@todo rappeler brièvement l'organisation du document
```
## Déroulement du projet
Pour réaliser ce projet, nous sommes passé par plusieurs phases de développement. 

Nous avons débuté ce projet par une phase de comprehension du besoin du client (Vépick).
Au cours de cette phase, nous avons mis en place un glossaire permettant de bien définir les termes présentés par
le client. Cette phase, nous a pris environ 4h.

Puis, à partir de notre compréhension de ces besoins, nous avons nous avons poursuivi par une phase de définition
du modèle conceptuel de donnée. Le modèle de données à beaucoup évolué au cours de cette phase.
C'est également lors de cette phase que nous avons émis des hypothèses sur les besoins de l'utilisateur que nous avons alors
répertorié dans un document. Cette phase nous a pris environ 8h.

Nous sommes ensuite entré dans une phase implementation de notre modèle conceptuel de donnée. C'est dans cette phase
que nous avons mappé nos classes avec JPA. Une fois fait nous avons put réaliser un schema de mapping JPA puis
nous avons généré notre modèle de donnée. Cette phase nous a pris environ 2h.

Nous avons ensuite commencé tous azimuts la phase de développement. Nous avons commencé par nous répartir différentes
tâches (sous le forme de vue qui permettaient des actions précises) et à développer celles-ci. Cependant, au terme d'une
semaine de développement, nous nous somme rendus compte qu'une partie non négligeable du code était redondant (les mêmes
fonctionnalitées avaient été implémentées plusieurs fois dans plusieurs classes différentes). En conséquence, nous avons dû
réorganiser notre développement. Cette réorganisation as pris la forme d'une nouvelle phase de conception plus théorique.

 Une fois notre vision fonctionelle claire, nous sommes à nouveau entrés dans une phase de développement. Cette fois 
avec bien plus de recul et d'aplomb.

## Organisation du projet et répartition des tâches
 Pendant les phases de conception, nous nous sommes tous réunis dans une salle afin de réfléchir tous ensemble et de 
nous accorder sur la conceptualisation de notre modèle de données. 

 Par la suite, nous avons réparti le travail dans des "issues" sur notre projet github. Chaque "issue" était alors attribuée 
à une ou deux personnes maximum. Pour correctement répartir les tâches et éviter les conflits, nous avons utilisé
les interfaces java afin de répartir le travail entre ceux qui utilisent et spécifient les interfaces et ceux qui les
implémentent. De cette façon, nous avons pu nous répartir le travail entre la mise en place de la vue, celle
des repository et celle des contrôleurs.

## Etat du projet rendu


## Choix de modélisation et évolution entre les deux rapports
 L'un des points névralgiques de nos discussions était sur la représentation d'une location d'un vélo par un client. Nous avions
initialement pensé à une classe associative "Location" entre la classe "Client" et la classe "Vélo". Les classes "Abonne" et "NonAbonne"
héritant toutes les deux de "Client" et les classes "LocationAbonne" et "LocationNonAbonne" héritant de "Location". Cela semblait être la
modélisation "naïve" en lisant l'énoncé du projet. Ce choix n'avait finalement pas beaucoup de sens dans la mesure où un client non abonné
n'existe pas avant ni après la location non abonné. Tous les attributs d'un client non abonné peuvent donc être stokés dans la classe
"LocationNonAbonne" et le système ne va pas conserver de trace de clients anonymes.
 En outre, nous n'avons pas apporté de modification supplémentaire au modèle conceptuel depuis le rapport intermédiaire. Nous avions passé
suffisament de temps en amont pour partir directement sur une piste qui nous satisfaisait.

## Modification apportées au schéma conceptuel et relationnel
=> manière utilisée pour valider le schéma conceptuel


## Scénario de test

## Test réalisés

