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
Le but du projet est de créer un système de gestion de vélos partagés similaire à ce que l'on peut trouver à lyon ou
paris avec leur Vélib. Le but est de permettre à n'importe quel usager de louer simplement un vélo afin de se déplacer

facilement dans Salem et Groville. Le système doit être simple, rapide, efficace et accessible à tous.

Pour réaliser cette application, nous utiliserons Java et le framework JPA, ainsi que le moteur de base de données 
MariaDB pour le développement, et si possible Oracle pour la mise en production. Afin de nous simplifier la tâche, nous
développerons notre interface homme-machine directement en console.

## Déroulement du projet
Pour réaliser ce projet nous sommes passé par plusieurs phase de développement. 

Nous somme d'abord passé par une phase d'appreciation du besoin où l'on as cherché à déterminer les besoins de l'utilisateur.
Au cour de cette phase nous avons mis en place un glossaire permettant de bien definir les termes tel que présenté par 
le client. Cette phase, nous a pris environ 4h.

Puis à partir de notre compréhension de ces besoins nous avons commencé à entrer dans une phase de conception qui
nous a permis de définir notre modèle conceptuel de donnée. Ce modèle de données à beaucoup évolué au cours de cette phase.
C'est aussi lors de cette phase que nous avons émis des hypothèses sur les besoins de l'utilisateur que nous avons alors
répertorié dans un document. Cette phase nous a pris environ 8h.

Nous sommes ensuite entré dans une phase implementation de notre modèle conceptuel de donnée. C'est dans cette phase
que nous avons mappé nos classe avec JPA.  Une fois fait nous avons pus réaliser un schema de mapping JPA puis 
nous avons généré notre modèle de donnée. Cette phase nous a pris environ 2h.

Nous avons ensuite commencé tous azimuts la phase de développement. Nous avons commencé par nous répartir différentes tâches (sous le forme de vue qui permettaient des actions précises) et
à développer celles-ci. Cependant, au terme d'une semaine de dévelloppement, nous nous somme rendus compte qu'une partie
non négligeable du code effectuais les mêmes fonctionnalitées et nous avons du réorganiser notre développement. Cette
réorganisation as pris la forme d'une nouvelle phase de conception plus théorique.

Une fois notre vision fonctionelle claire, nous sommes à nouveau entré dans une phase de développement. Cette fois 
avec bien plus de recul et d'aplomb.

## Organisation du projet et répartition des tâches
Pendant les phases de conception, nous nous somme tous réunis dans une salle afin de réfléchir tous ensemble et de 
nous accorder sur la conceptualisation de notre modèle de données. 

Par la suite nous avons répartie le travail dans des "issues" sur notre projet github. Chaques "issue" été alors attribué 
à une ou deux personnes maximal. Pour correctement répartir les tâches et éviter les conflits, nous avons utilisé
les interface java afin de répartir le travail entre ceux qui utilise et spécifie les interfaces et ceux qui les
implémente. De cette façons nous avons pu nous répartir le travail entre la mise en place de la vue la mise en place
des repository et la mise en place des contrôleurs.


