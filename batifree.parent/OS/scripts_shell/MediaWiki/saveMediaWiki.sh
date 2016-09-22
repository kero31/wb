#!/bin/sh

# Déclarations des variables
DATE=`date +'%Y-%m-%d'` # date au format année-mois-jour
REP_SAUV="/usr/share/apache-tomcat-8.0.11/tomcat"
REP_MW="mediawiki"
PATH_PARENT_MW="/usr/local"
PATH_MW="${PATH_PARENT_MW}/${REP_MW}"

# Préparatifs
if [ ! -d "$PATH_MW" ] ; then
    echo "Erreur : le répertoire à sauvegarder ($PATH_MW) n'existe pas !"
    exit 1
fi
if [ ! -d "$REP_SAUV" ] ; then
    mkdir -p "$REP_SAUV" || exit 2
fi

# Sauvegarde des fichiers
cd ${PATH_PARENT_MW}
tar cf - ${REP_MW} | bzip2 -9 > "${REP_SAUV}/mediawiki_${DATE}.tar.bz2"

# Sauvegarde de la base de données
mysqldump --user=root --password=rootBF mediawiki | bzip2 -9 > "${REP_SAUV}/mediawiki_${DATE}.dump.bz2"

# Sauvegarde des fichiers sur un autre serveur
sshpass -p "test123" scp "${REP_SAUV}/mediawiki_${DATE}.tar.bz2" test@192.168.9.13:/tmp
sshpass -p "test123" scp "${REP_SAUV}/mediawiki_${DATE}.dump.bz2" test@192.168.9.13:/tmp