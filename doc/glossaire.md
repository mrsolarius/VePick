# Glossaire

## A

### Abonné

Cf. _[A12] [A15]_\
Un abonné est un **[usager](#Usager)** ayant acheté un **[abonnement](#Abonnement)** valable. Ses informations personnelles sont
enregistrées, et il bénéficie d’une réduction de **[location](#location)** et s'identifie grâce à son **[mot de passe](#mot-de-passe)**.

### Abonnement

Cf. _[A14]_\
Un abonnement permet à un **[usager](#Usager)** d'effectuer des **[location](#location)** avec plus de facilités et
avec un tarif reduit.

## C

### Code

Cf. _[A16] [A20]_\
Un **[code](#Code)** est un identifiant unique qui permet a chaque **[usager](#Usager)** **[non abonné](#Non-Abonné)** de s’identifier afin de remettre une **[location](#Location)** à une **[Station](#Station)**.

### Crédit-temps

Cf. _[A28] [A29]_\
Le **[credit-temps](#Crédit-temps)** est un compte de minutes déductible du temps de **[location](#Location)**.
Il est crédité d'une minute à chaque fois qu'un **[abonné](#Abonné)** a effectué
une **[location](#Location)** qui participe au système de **[régulation citoyenne](#régulation-citoyenne)**

## B

### Borne

Cf. _[A22]_\
Une **[borne](#Borne)** est un équipement qui permet à l' **[usager](#Usager)** d'interagir avec VéPick afin d'effectuer
la **[location](#Location)** d'un vélo. C'est l'intermédiaire entre le **[usager](#Usager)** et la **[Station](#Station)**.

### Bornette

Cf. _[A2] [A3]_\
Emplacement d’une **[station](#Station)** pouvant héberger un **[vélo](#Vélo)**.

## E

### État

Cf. _[A4]_\
Un **[vélo](#Vélo)** et une **[bornette](#bornette)** ont forcément un état, OK s'ils sont en état de fonctionner ou HS en cas de problème technique signalé.

## L

### Location

Cf. _[A20] [A21] [A26]_\
Une **[location](#location)** est définie par une date de départ, un temps de location et un prix.
Elle permet à un **[usager](#Usager)** de louer un **[vélo](#Vélo)**.

### Location Non Abonné

Cf. _[A20]_\
Une **[Location Non Abonné](#Location-Non-Abonné)** est définie par une date de départ un temps de location,
un prix un code de carte bleu et un **[code](#code)**. Elle permet à un **[usager](#Usager)** **[non abonné](#Non-Abonné)** de louer un **[vélo](#Vélo)**. Lorsqu'un **[usager](#Usager)** non abonné loue un **[vélo](#Vélo)**,il doit renseigner
son code de carte bleu. Une fois la transaction effectuée, le **[code](#code)** est délivré.

### Location Abonné

Cf. _[A15] [A16] [A20] [A28] [A29]_\
Une **[Location Abonné](#Location-Abonné)** est définie par une date de départ un temps de location, un prix.
Elle permet à un **[usager](#Usager)** abonné de louer un **[vélo](#Vélo)** plus facilement.
Et de bénéficier d’une réduction de location. Ainsi que d'un **[credit-temps](#Crédit-temps)** grace au système de **[régulation citoyenne](#régulation-citoyenne)**.

## M

### Modèle

Cf. _[A4] [A9] [[H6]](hypothèse.md#h6-Hypothèse-6)_\
Le modèle d’un **[vélo](#Vélo)** correspond à un type de vélo du parc VéPick, il est associé à un nom qui l'identifie [[H6]](hypothèse.md#h6-Hypothèse-6) et à un prix.

### Mot De Passe

Cf. _[A12]_\
Le mot de passe permet à un **[abonné](#Abonné)** de s'identifier.

## N

### Non Abonné

Cf._[A20]_\
Un **[non abonné](#Non-abonné)** est un **[usager](#usager)** qui n'a pas pris d' **[abonnement](#abonnement)**.

## R

### Régulation Citoyenne

Cf. _[A28] [A29]_\
Le système de **[régulation citoyenne](#régulation-citoyenne)** permet à VePick d'assurer une disponibilité des vélos en remplissant les **[stations](#Station)** sur lesquelles la demande est forte et inversement de laisser des **[bornettes](#bornette)** libres sur les **[stations](#Station)** de destination. Ainsi chaque station se voit
attribuer un status **[VStatus](#VStatus)** correspondant à l'importance que l'algorithme de VePick devra apporter à chaque station. Ce système participatif se base sur un **[credit-temps](#Crédit-temps)** accordé à chaque **[abonné](#Abonné)** lorsqu'il rend un **[vélo](#Vélo)** sur une station définie par l'algorithme plutôt que sur sa station habituelle.

### Station

Cf. _[A1] [A2] [A3]_\
Emplacement composé d'une **[borne](#borne)** elle même constituée de plusieurs **[bornettes](#Bornette)** , chacune pouvant héberger
un **[vélo](#Vélo)**. La Station est située à une adresse précise.

## U

### Usager

Cf. _[A12] [A15] [A16] [A20] [A21] [A26] [A28] [A29]_\
Un **[Usager](#Usager)** est une personne qui utilise le service VéPick. Il peut être un **[abonné](#abonné)** ou un **[non abonné](#non-abonné)**.

## V

### Vélo

Cf. _[A4]_\
Un **[vélo](#Vélo)** (abréviation du mot _vélocipède_), est un véhicule terrestre à propulsion humaine entrant dans
la catégorie des cycles et composé de deux roues alignées, qui lui donnent son nom. La force motrice est fournie par
son conducteur (appelé « cycliste »), en position le plus souvent assise, par l'intermédiaire de deux pédales entraînant
la roue arrière par une chaîne à rouleaux. Ici un **[vélo](#Vélo)** a un numéro unique, une date de mise en circulation ainsi qu’un **[état](#État)** et un **[modèle](#Modèle)**.

### VStatus

Cf. _[A27] [A28] [A29] [A30] [A31] [A32]_\
Le **[VStatus](#VStatus)** est le statut d'une **[station](#Station)** il est defini manuellement par l'administrateur selon un planning. Il existe 3 statuts :

- VPlus : la station à besoin de plus de vélos
- VMoins : la station à besoin de moins de vélos
- VNul : la station n'a pas de besoin de vélos

L'algorithme de VePick va prioriser les **[station](#Station)** ayant un **[VStatus](#VStatus)** VPlus. En proposant à l'**[abonné](#Abonné)** un **[credit-temps](#Crédit-temps)** s'il dépose leur vélo sur une **[station](#Station)** ayant
le **[VStatus](#VStatus)** VPlus.
De même l'algorithme de VePick va vider les **[station](#Station)** ayant un **[VStatus](#VStatus)** VMoins. En proposant
au **[abonné](#Abonné)** un **[credit-temps](#Crédit-temps)** s'il récupère leur vélo sur une **[station](#Station)**
ayant le **[VStatus](#VStatus)** VMoins Lolilol.
