
Testé avec le JDK 1.8, EJB Lite avec JEE 6 API et glassfish 4.1.
Pour lancer le projet en mode debug :

Ouvrir les propriétés du projet -> Libraries -> Add Library : 
	Choisir JAVA EE 6 API Library.
Ouvrir les propriétés du projet -> Libraries -> Add JAR/Folder :
	Trouver glassfish-embedded-static-shell.jar dans <Glassfish folder>\glassfish\lib\embedded.

Créer la base de données dans Netbeans (derby) :
	Database Name: ParkingDB
	User Name: nbuser 
	Password: nbuser
	
Démarrer le serveur glassfish avant de lancer le projet.