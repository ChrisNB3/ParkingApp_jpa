
Test� avec le JDK 1.8, EJB Lite avec JEE 6 API et glassfish 4.1.
Pour lancer le projet en mode debug :

Ouvrir les propri�t�s du projet -> Libraries -> Add Library : 
	Choisir JAVA EE 6 API Library.
Ouvrir les propri�t�s du projet -> Libraries -> Add JAR/Folder :
	Trouver glassfish-embedded-static-shell.jar dans <Glassfish folder>\glassfish\lib\embedded.

Cr�er la base de donn�es dans Netbeans (derby) :
	Database Name: ParkingDB
	User Name: nbuser 
	Password: nbuser
	
D�marrer le serveur glassfish avant de lancer le projet.