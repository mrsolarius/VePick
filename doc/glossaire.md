# Glossaire

## A

### Abonné

Cf. _[A12] [A15]_\
Un abonné est un **[usager](#usager)** ayant acheté un **[abonnement](#abonnement)** valable. Ses informations personnelles sont
enregistrées, et il bénéficie d’une réduction de **[location](#location)** et s'identifie grâce à son **[mot de passe](#mot-de-passe)**.

### Abonnement

Cf. _[A14]_\
Un abonnement permet à un **[usager](#usager)** d'effectuer des **[locations](#location)** avec plus de facilités et
avec un tarif reduit.

## B

### Borne

Cf. _[A22]_\
Une **[borne](#borne)** est un équipement qui permet à l'**[usager](#usager)** d'interagir avec VéPick afin d'effectuer
la **[location](#location)** d'un vélo. C'est l'intermédiaire entre l'**[usager](#usager)** et la **[station](#station)**.

### Bornette

Cf. _[A2] [A3]_\
Emplacement d’une **[station](#station)** pouvant héberger un **[vélo](#vélo)**.

## C

### Code

Cf. _[A16] [A20]_\
Un **[code](#code)** est un identifiant unique qui permet à chaque **[usager](#usager)** **[non abonné](#non-abonné)** de s’identifier afin de remettre une **[location](#location)** à une **[station](#station)**.

### Crédit-temps

Cf. _[A28] [A29]_\
Le **[crédit-temps](#crédit-temps)** est un compte de minutes déductibles du temps de **[location](#location)**.
Il est crédité d'une minute à chaque fois qu'un **[abonné](#abonné)** a effectué
une **[location](#location)** qui participe au système de **[régulation citoyenne](#régulation-citoyenne)**

## E

### État

Cf. _[A4] [[H8]](hypothèse.md#h8-Hypothèse-8)_\
Un **[vélo](#vélo)** et une **[bornette](#bornette)** ont forcément un état, OK s'ils sont en état de fonctionner ou HS en cas de problème technique signalé. Ils peuvent également avoir comme état "maintenance" s'ils sont en maitenance (parce qu'ils étaient HS / pour révision).

## L

### Location

Cf. _[A20] [A21] [A26]_\
Une **[location](#location)** est définie par une date de départ, un temps de location et un prix.
Elle permet à un **[usager](#usager)** de louer un **[vélo](#vélo)**.

### Location Non Abonné

Cf. _[A20]_\
Une **[location non abonné](#location-non-abonné)** est définie par une date de départ, un temps de location,
un prix, un code de carte bleu et un **[code secret](#code)**. Elle permet à un **[usager](#usager)** **[non abonné](#non-abonné)** de louer un **[vélo](#vélo)**. Lorsqu'un **[usager](#usager)** non abonné loue un **[vélo](#vélo)**, il doit renseigner
son code de carte bleu. Une fois la transaction effectuée, le **[code](#code)** est délivré.

### Location Abonné

Cf. _[A15] [A16] [A20] [A28] [A29]_\
Une **[location abonné](#location-abonné)** est définie par une date de départ un temps de location et un prix.
Elle permet à un **[usager](#usager)** **[abonné](#abonné)** de louer un **[vélo](#vélo)** plus facilement.
Ainsi que de bénéficier d’une réduction de location, et d'un **[crédit-temps](#crédit-temps)** grâce au système de **[régulation citoyenne](#régulation-citoyenne)**.

## M

### Modèle

Cf. _[A4] [A9] [[H6]](hypothèse.md#h6-Hypothèse-6)_\
Le modèle d’un **[vélo](#vélo)** correspond à un type de vélo du parc VéPick, il est associé à un nom qui l'identifie [[H6]](hypothèse.md#h6-Hypothèse-6) et à un prix.

### Mot De Passe

Cf. _[A12]_\
Le mot de passe permet à un **[abonné](#abonné)** de s'identifier.

## N

### Non Abonné

Cf._[A20]_\
Un **[non abonné](#non-abonné)** est un **[usager](#usager)** qui n'a pas pris d'**[abonnement](#abonnement)**.

## R

### Régulation Citoyenne

Cf. _[A28] [A29]_\
Le système de **[régulation citoyenne](#régulation-citoyenne)** permet à VePick d'assurer une disponibilité des vélos en remplissant les **[stations](#station)** sur lesquelles la demande est forte et inversement de laisser des **[bornettes](#bornette)** libres sur les **[stations](#station)** de destination. Ainsi chaque station se voit attribuer un statut **[VStatut](#vstatut)** correspondant à l'importance que l'algorithme de VePick devra apporter à chaque station. Ce système participatif se base sur un **[crédit-temps](#crédit-temps)** accordé à chaque **[abonné](#abonné)** lorsqu'il rend un **[vélo](#vélo)** sur une station définie par l'algorithme plutôt que sur sa station habituelle.

### Station

Cf. _[A1] [A2] [A3]_\
Emplacement composé d'une **[borne](#borne)** elle-même constituée de plusieurs **[bornettes](#bornette)**, chacune pouvant héberger
un **[vélo](#vélo)**. La **[station](#station)** est située à une adresse précise.

## U

### Usager

Cf. _[A12] [A15] [A16] [A20] [A21] [A26] [A28] [A29]_\
Un **[Usager](#usager)** est une personne qui utilise le service VéPick. Il peut être un **[abonné](#abonné)** ou un **[non abonné](#non-abonné)**.

## V

### Vélo

Cf. _[A4]_\
Un **[vélo](#vélo)** (abréviation du mot _vélocipède_), est un véhicule terrestre à propulsion humaine entrant dans la catégorie des cycles et composé de deux roues alignées, qui lui donnent son nom. La force motrice est fournie par son conducteur (appelé « cycliste »), en position le plus souvent assise, par l'intermédiaire de deux pédales entraînant la roue arrière par une chaîne à rouleaux. Ici un **[vélo](#vélo)** a un numéro unique, une date de mise en circulation, ainsi qu’un **[état](#état)** et un **[modèle](#modèle)**.

### VStatut

Cf. _[A27] [A28] [A29] [A30] [A31] [A32]_\
Le **[VStatut](#vstatut)** est le statut d'une **[station](#station)**. Il est défini manuellement par l'administrateur selon un planning. Il existe 3 statuts :

- VPlus : la station a besoin de plus de vélos
- VMoins : la station a besoin de moins de vélos
- VNul : la station n'a pas besoin spécifiquement de vélos

L'algorithme de VéPick va prioriser les **[stations](#station)** ayant un **[VStatut](#vstatut)** VPlus, en proposant à l'**[abonné](#abonné)** un **[crédit-temps](#crédit-temps)** s'il dépose son **[vélo](#vélo)** sur une **[station](#station)** ayant le **[VStatut](#vstatut)** VPlus.
De même l'algorithme de VéPick va vider les **[stations](#station)** ayant un **[VStatut](#vstatut)** VMoins, en proposant aux **[abonnés](#abonné)** un **[crédit-temps](#crédit-temps)** s'ils récupèrent leurs **[vélos](#vélo)** sur une **[station](#station)** ayant le **[VStatut](#vstatut)** VMoins.
