#!/bin/sh

# Déclarations des variables
DATE=`date +'%Y-%m-%d_%H:%M:%S'` # date au format année-mois-jour
SAVE_DUMP_FILE="/usr/share/apache-tomcat-8.0.11/tomcat/bd_dump_${DATE}.dump.bz2"

# Sauvegarde de la base de données
mysqldump --user=root --password=rootBF -A | bzip2 -9 > "${SAVE_DUMP_FILE}"

# Sauvegarde des fichiers sur un autre serveur
sshpass -p "test123" scp $SAVE_DUMP_FILE test@192.168.9.13:/tmp
