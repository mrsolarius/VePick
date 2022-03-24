# Rapport Projet VéPick
Code sources disponibles sur [Github](https://github.com/mrsolarius/ProjetBDD)

Membres du projet :
* *Adam MOUSSOLNA*
* *Julien TURC*
* *Louis VOLAT*
* *Lucas ZAETTA*
* *Hubert ZODJIHOUE*

```
@todo rappeler brièvement l'organisation du document
@todo indiquer les modification apporter au modèle conceptuel/relationelle/mappingJPA
@todo indiquer l'avancement du projet
@todo présenter nos scénarios de test
@todo présenter notre peuplement de données et nos testes
```

## Objectifs du projet
Le but du projet est de créer un système de gestion de vélos partagés similaire à ce que l'on peut trouver à Lyon ou
Paris avec Vélib. Le but est de permettre à nimporte quel usager de louer simplement un vélo afin de se déplacer
facilement dans Salem et Groville. Le système doit être simple, rapide, efficace et accessible à tous.

Pour réaliser cette application, nous utiliserons Java et le framework JPA, ainsi que le moteur de base de données 
MariaDB pour le développement, et si possible Oracle pour la mise en production. Afin de nous simplifier la tâche, nous
développerons notre interface homme-machine directement en console.

## Déroulement du projet
Pour réaliser ce projet nous sommes passés par plusieurs phases de développement. 

Nous sommes d'abord passé par une phase d'appréciation du besoin où l'on a cherché à déterminer les besoins de l'utilisateur.
Au cours de cette phase nous avons mis en place un glossaire permettant de bien definir les termes présentés par 
le client. Cette phase nous a pris environ 4 heures.

Puis, à partir de notre compréhension de ces besoins nous avons commencé à entrer dans une phase de conception qui
nous a permis de définir notre modèle conceptuel de données. Ce modèle de donnés à beaucoup évolué au cours de cette phase.
C'est aussi lors de cette phase que nous avons émis des hypothèses sur les besoins de l'utilisateur, que nous avons alors
répertoriés. Cette phase nous a pris environ 8 heures.

Nous sommes ensuite entrés dans une phase d'implémentation de notre modèle conceptuel de données. C'est dans cette phase
que nous avons mappés nos classes avec JPA.  Une fois cette phase exécutée, nous avons pu réaliser un schéma de mapping JPA puis 
nous avons généré notre modèle de données. Cette phase nous a pris environ 2 heures.

Nous avons ensuite commencé la phase de développement. Cependant, par manque de structuration et de
consigne claire sur la répartition des tâches, nous avons constaté que l'on allait réaliser plusieurs fois le même travail.
C'est pourquoi nous sommes entrés dans une nouvelle phase de conception, cette fois-ci plus axée sur l'implémentation du code
et sur nos méthodes de travail.

Une fois notre vision fonctionelle claire, nous sommes à nouveau entré dans une phase de développement. Cette fois 
avec bien plus de recul et d'aplomb.

## Organisation du projet et répartition des tâches
Pendant les phases de conception, nous nous somme tous réunis dans une salle afin de réfléchir tous ensemble et de 
nous accorder sur la conceptualisation de notre modèle de données. 

Par la suite, nous avons réparti le travail dans des issues sur notre projet github. Chaques issue était alors attribué 
à une ou deux personnes maximum. Pour correctement répartir les tâches et éviter les conflits, nous avons utilisé
les interfaces java afin de répartir le travail entre ceux qui utilisent et spécifient les interfaces et ceux qui les
implémentent. De cette façon, nous avons pu nous répartir le travail entre la mise en place de la vue, la mise en place
des repositories et la mise en place des contrôleurs.
