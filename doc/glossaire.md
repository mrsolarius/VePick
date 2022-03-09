# Glossaire

## A
### Abonné
Cf. *[A12] [A15]*\
Un abonné est un **[usager](#Usager)** ayant acheté un **[abonnement](#Abonnement)** valable. Ses informations personnelles sont 
enregistrées, et il bénéficie d’une réduction de **[location](#location)**.

### Abonnement
Cf. *[A14]*\
Un abonnement permet à un **[usager](#Usager)** d'effectuer des **[location](#location)** avec plus de facilités et 
avec un tarif reduit.

## C
### Code 
Cf. *[A16] [A20]*\
Un **[code](#Code)** est un identifiant unique qui permet a chaque **[usager](#Usager)** de s’identifier afin de
remettre une **[location](#Location)** à une **[Station](#Station)**. Il peut est unique à **[abonné](#Abonné)** ou à
la **[location](#Location)** si il s'agit d'un **[usager](#Usager)** non abonné.

### Crédit-temps
Cf. *[A28] [A29]*\
Le **[credit-temps](#Crédit-temps)** est un compte de minutes sur déductible du temps de **[location](#Location)**.
Il est crédité de une minutes à chaque fois que un **[abonné](#Abonné)** lorsqu’il a effectué 
une **[location](#Location)** qui participe au système de **[régulation citoyenne](#régulation-citoyenne)**

## B
### Borne
Cf. *[A22]*\
Une **[borne](#Borne)** est un équipement qui permet au **[usager](#Usager)** d'interagir avec VéPick afin d'effectuer
la **[location](#Location)** d'un vélo. C'est l'intermédiaire entre le **[usager](#Usager)** et la **[Station](#Station)**.

### Bornette
Cf. *[A2] [A3]*\
Emplacement d’une **[station](#Station)** pouvant héberger un **[vélo](#Vélo)**.

## E
### État
Cf. *[A4]*\
Un **[vélo](#Vélo)** et une **[bornette](#bornette)** ont forcément un état, OK ou HS en cas de problème technique.

## L
### Location
Cf. *[A20] [A21] [A26]*\
Une **[location](#location)** est défini par une date de départ un temps de location et un prix. 
Elle permet à un **[usager](#Usager)** de louer un ou plusieurs **[vélo](#Vélo)**.

### Location Non Abonné
Cf. *[A20]*\
Une **[Location Non Abonné](#Location-Non-Abonné)** est défini par une date de départ un temps de location, 
un prix un code de carte bleu et un **[code](#code)**. Elle permet à un **[usager](#Usager)** non abonné
de louer un **[vélo](#Vélo)**. Lorsque un **[usager](#Usager)** non abonné loue un **[vélo](#Vélo)**, doit renseigner
son code de carte bleu. Une fois la transaction effectuée, le **[code](#code)** est délivré.

### Location Abonné
Cf. *[A15] [A16] [A20] [A28] [A29]*\
Une **[Location Abonné](#Location-Abonné)** est défini par une date de départ un temps de location, un prix. 
Elle permet à un **[usager](#Usager)** abonné de louer un **[vélo](#Vélo)** plus facilement. 
Et de bénéficier d’une réduction de location. Ainsi que d'un **[credit-temps](#Crédit-temps)** grace au système de **[régulation citoyenne](#régulation-citoyenne)**.

## R
### Régulation Citoyenne
Cf. *[A28] [A29]*\
Le système de **[régulation citoyenne](#régulation-citoyenne)** permet à VePick d'assurer une disponibilité des velos 
en remplissant les **[stations](#Station)** sur lesquels la demande et forte et inversement de laisser 
des **[bornettes](#bornette)** libres sur les **[stations](#Station)** de destination. Ainci chaque station se voit 
attribuer un status **[VStatus](#VStatus)** correspondent à l'importance que l'algorithm de VePick devras apporter 
à chaque station. Ce système participatif se base sur un **[credit-temps](#Crédit-temps)** accordé à chaque 
**[abonné](#Abonné)** lorsqu'il rende un **[vélo](#Vélo)** sur une station défini par l'algorithme plutôt que 
sur leur station habituelle.

### Station 
Cf. *[A1] [A2] [A3]*\
Emplacement composé d'une **[borne](#borne)** et de plusieurs **[bornettes](#Bornette)** pouvant héberger 
des **[vélo](#Vélo)** situé à une adresse précise l'identifiant.

## u
### Usager
Cf. *[A12] [A15] [A16] [A20] [A21] [A26] [A28] [A29]*\
Un **[Usager](#Usager)** est une personne qui utilise le service VéPick. Il peut être un **[abonné](#abonné)** ou un non.

## V
### Vélo
Un **[vélo](#Vélo)** (abréviation du mot *vélocipède*), est un véhicule terrestre à propulsion humaine entrant dans 
la catégorie des cycles et composé de deux roues alignées, qui lui donnent son nom. La force motrice est fournie par 
son conducteur (appelé « cycliste »), en position le plus souvent assise, par l'intermédiaire de deux pédales entraînant
la roue arrière par une chaîne à rouleaux. Ici un **[vélo](#Vélo)** à un numéro unique, une date de mise en circulation 
ainsi qu’un **[état](#État)**.

### VStatus
Cf. *[A27] [A28] [A29] [A30] [A31] [A32]*\
Le **[VStatus](#VStatus)** est un status d'une **[station](#Station)** il est definis manuellement par l'administrateur 
selon un planning. Il existe 3 status :
 - VPlus : la station à besoin de plus de vélos
 - VMoins : la station à besoin de moins de vélos
 - VNull : la station n'a pas de besoin de vélos

L'algorithme de VePick va prioriser les **[station](#Station)** ayant un **[VStatus](#VStatus)** VPlus. En proposant au
**[abonné](#Abonné)** un **[credit-temps](#Crédit-temps)** si il dépose leur vélo sur une **[station](#Station)** ayant 
le **[VStatus](#VStatus)** VPlus.
De même l'algorithme de VePick va vidé les **[station](#Station)** ayant un **[VStatus](#VStatus)** VMoins. En proposant
au **[abonné](#Abonné)** un **[credit-temps](#Crédit-temps)** si il récupère leur vélo sur une **[station](#Station)** 
ayant le **[VStatus](#VStatus)** VMoins.
