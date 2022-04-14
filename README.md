# Tp_Web_Service

# Objectif

 Montrer comment creer un simple web service dans une application Java puis regarder le WSDL, tester le web service et enfin creer un client java et un client .NET
 
# Partie 1 : creation d'un web service et une simple application java pour le consommer :
 
 -Pour creer un web service on a besoin de creer une simple classe  java contient des methodes.
 
 -Creation de serveur qui deploi le web service  en indiquant l'url et le port et  le  web service (l'instance de notre class )
 
## Demmarage de serveur JaxWS
 
 ![ws1](https://user-images.githubusercontent.com/102171913/163439807-0f508bf2-e992-4015-9a44-a417f60637c1.PNG)

## L'utilisation du navigateur pour visualiser notre WSDL 

#### Remarque:
j'ai changé le numero de port 😊

![ws2](https://user-images.githubusercontent.com/102171913/163440507-07fd24a7-f1e2-4fde-92ab-a20f3ccde265.PNG)

-On constate q'un WSDL est un document xml contient des schémas xml expliquent l'interface de web service (les methodes et leurs parametres d'entrer et sortie)

-Pour chaque methode il y a deux message l'un decrit l'input et l'autre decrit l'output
un methode fait reference a un parammetre declarer dans le shema xml trouver dans le chemin url/xsd=1 generer par JaxWS 

## Le schéma xml (xsd)

![ws xsd](https://user-images.githubusercontent.com/102171913/163442120-a2a8335c-9ec3-4104-aecd-59d0d279e2b5.PNG)

## Tester notre web service avec SoapUI

Tout d'abord on doit creer un nouveau Soap projet en indiquant l'adresse de WSDL de notre web service

![new soap project](https://user-images.githubusercontent.com/102171913/163442909-38ad87e8-be36-496f-b955-65b525f75311.PNG)

puis on recoit les methodes trouvés dans le web service et on peut les testés avec SoapUI:

#### Methode CoversionEuroToDH():

![conversion eurodh soap request1](https://user-images.githubusercontent.com/102171913/163443241-cc53cbc7-d239-4e0f-8480-86954ece5a1f.PNG)

#### Methode getCompte():

![get compte soap](https://user-images.githubusercontent.com/102171913/163443267-47de2f7d-2913-4afa-b852-7a06c7d5319f.PNG)

#### Methode listesComptes():

![liste comptes soap](https://user-images.githubusercontent.com/102171913/163443330-3c632adf-9869-4175-a977-df6b4855ad6b.PNG)

On note que dans l'application on utilise JaxBinding par defaut, 
on explore l'une de ses annotation(JaxB) (@XMLTrasient) pour n'a pas visualiser un attribut

![notations jaxB](https://user-images.githubusercontent.com/102171913/163448843-f215c8d7-8b24-421a-82d8-36bf1e06f002.PNG)

#### Resultat dans Soap aprés la modification:

![soap apres annotation](https://user-images.githubusercontent.com/102171913/163448890-8678b059-4ade-4500-a6a9-5acfeec03d10.PNG)

## Application java pour le client

on doit creer une application Java pour client permet de consommer le web service

-Tout d'abord on va generer un proxy a  partir de WSDL c.a.d generer des classes et des interfaces qui je peut les utilisés pour comuniquer avec le web service.

-On a generer le WSDL dans un package proxy 

![image](https://user-images.githubusercontent.com/102171913/163454597-dae5feb3-dfab-434d-943a-96f6160e7508.png)

-On a cree une application java dans laquelle on faire appele a des la classe dans le proxy qu'ona generer (l'invocation de methodes a distance).

### Comment ça marche:

le client demmande au stub de faire appel à une methode, le stub se connecte au JaxWS (SKELETON)(c'est l'intermmediare coté serveur) qui recoit la requette et faire appele à la methode du web service puis recupére le resultat et envoyé le resultat en format xml au le stub (qui l'intermediaire coté client) qui prend le resultat et le fournit au client

#### Remarque:

On peut tout simplement generer le proxy sur lingne de comande avec la commande 
#### --> wsimport -s .Adresse_wsdl

![image](https://user-images.githubusercontent.com/102171913/163473074-35aa042f-a0fb-4536-9412-a1006c7206f2.png)

#### l'execution de notre application java:

![execution](https://user-images.githubusercontent.com/102171913/163473454-64b1e6c5-e856-4818-bc65-19655825ff45.PNG)

# Partie 2 :  consommer Notre web service dans une application .Net

Tout d'abord on doit génerer le proxy a partir de WSDL:

![generation  net](https://user-images.githubusercontent.com/102171913/163473902-c7dcf1c7-c566-41a6-bf43-4baedb95dc9e.PNG)

aprés on a creer une simple application .Net (orienté objet distribué) qui affiche la conversion euro to dh et la liste des comptes avec le solde.

#### Resultat:

![execution 2](https://user-images.githubusercontent.com/102171913/163474585-4b6d551e-cb5b-4595-a572-f9b03d45708c.PNG)





 
 
 
