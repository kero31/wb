/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  03/11/2014 23:13:24                      */
/*==============================================================*/


SET foreign_key_checks = 0;
drop table if exists ACCESDROIT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ACOMPTE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ACTIVITE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists AFFAIRE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists AVOIR;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists BIBLIOTHEQUE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists BINAIRE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists CATEGORIE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists CHANTIER;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists CHARGEAFFAIRE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists CIVILITE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists CLIENT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists CODIFICATION;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists CONTACT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists COORDONNEECNT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists DETAILCNT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists DEVIS;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists DIVERSCNT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ECHEANCIER;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ECHEANCIER_REGLEMENT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ENGIN;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ENGIN_BIB;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ENGIN_ETUDE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ETAT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ETUDE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists FACTURE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists FAMILLE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists FOURNISSEUR;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists FOURNISSEUR_MATERIAUX;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists GROUPECNT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists GROUPECNT_DIVERSCNT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists IMAGE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists LOCALISATION;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists MAINOEUVRE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists MAINOEUVRE_BIB;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists MAINOEUVRE_ETUDE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists MATERIAUX;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists MATERIAUX_BIB;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists MATERIAUX_ETUDE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists MODE_PAIEMENT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists PAYS;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists PREFERENCE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists REGLEMENT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists SITUATION;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists SKIN;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists SOUSTRAITANT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists SOUSTRAITANT_BIB;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists SOUSTRAITANT_ETUDE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists TACHE_LOT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists TACHE_LOT_BIB;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists TACHE_LOT_ETUDE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists TVA;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists UNITE;
SET foreign_key_checks = 1;

/*==============================================================*/
/* Table : ACCESDROIT                                           */
/*==============================================================*/
create table ACCESDROIT
(
   ACC_ID               int(7) not null auto_increment,
   primary key (ACC_ID)
);

/*==============================================================*/
/* Table : ACOMPTE                                              */
/*==============================================================*/
create table ACOMPTE
(
   AFF_ID               int(7) not null,
   DEV_ID               int(7) not null,
   primary key (AFF_ID)
);

/*==============================================================*/
/* Table : ACTIVITE                                             */
/*==============================================================*/
create table ACTIVITE
(
   ACT_ID               int(7) not null auto_increment,
   ACT_LIBELLE          varchar(30),
   primary key (ACT_ID)
);

/*==============================================================*/
/* Table : AFFAIRE                                              */
/*==============================================================*/
create table AFFAIRE
(
   AFF_ID               int(7) not null auto_increment,
   BIN_NOTES            int(7),
   CHT_ID               int(7),
   BIN_METRE            int(7),
   BIN_DESCRIPTIF       int(7),
   BIN_INTRODUCTION     int(7),
   ETA_ID               int(7) not null,
   BIN_CONCLUSION       int(7),
   CNT_ID               int(7),
   AFF_CODE             varchar(30),
   AFF_REFERENCE        varchar(40),
   AFF_DATE_CREATION    datetime,
   AFF_DATE_MAJ         datetime,
   AFF_TERMINE          bool,
   AFF_VALIDE           bool,
   AFF_DUREE_VALIDITE   datetime,
   AFF_DATE_DEB_TRAVAUX datetime,
   AFF_DATE_FIN_TRAVAUX datetime,
   AFF_DATE_CLOTURE     datetime,
   primary key (AFF_ID)
);

/*==============================================================*/
/* Table : AVOIR                                                */
/*==============================================================*/
create table AVOIR
(
   AFF_ID               int(7) not null,
   FAC_ID               int(7) not null,
   primary key (AFF_ID)
);

/*==============================================================*/
/* Table : BIBLIOTHEQUE                                         */
/*==============================================================*/
create table BIBLIOTHEQUE
(
   BIB_ID               int(7) not null auto_increment,
   BIN_DESC_TECHINIQUE  int(7),
   BIB_ORIGIN           int(7),
   BIN_NOTES            int(7),
   IMG_IMAGE            int(7),
   BIN_METRE            int(7),
   BIN_DESCRIPTIF       int(7),
   BIN_DESC_COMMERCIAL  int(7),
   FAM_ID               int(7),
   TVA_ID               int(7) not null,
   ETU_ID               int(7),
   BIB_BORNE_GAUCHE     numeric(7,0) not null comment 'Borne gauche',
   BIB_BORNE_DROITE     numeric(7,0) not null comment 'Borne droite',
   BIB_NIVEAU           numeric(7,0) not null comment 'Niveau (0 : racine, 1 niveau 1er, ...)',
   BIB_ORDRE            numeric(7,0),
   BIB_PARENT           numeric(7,0) comment 'Super parent id',
   BIB_CODE             varchar(20),
   BIB_MOT_CLE          varchar(20),
   BIB_NUM_SERIE        varchar(20),
   BIB_UNITE            varchar(10),
   BIB_PRIX_ACHAT       float(8,2),
   BIB_FRAIS_GENERAUX   numeric(5,2),
   BIB_BENEFICE         numeric(5,2),
   BIB_DATE_CREATION    datetime,
   BIB_DATE_MAJ         datetime,
   BIB_BAR_CODE         varchar(50),
   BIB_QUANTITE         numeric(11,3),
   primary key (BIB_ID)
);

/*==============================================================*/
/* Index : BIB_IDX_BORNE_GAUCHE                                 */
/*==============================================================*/
create index BIB_IDX_BORNE_GAUCHE on BIBLIOTHEQUE
(
   BIB_BORNE_GAUCHE
);

/*==============================================================*/
/* Index : BIB_IDX_BORNE_DROITE                                 */
/*==============================================================*/
create index BIB_IDX_BORNE_DROITE on BIBLIOTHEQUE
(
   BIB_BORNE_DROITE
);

/*==============================================================*/
/* Index : BIB_IDX_NIVEAU                                       */
/*==============================================================*/
create index BIB_IDX_NIVEAU on BIBLIOTHEQUE
(
   BIB_NIVEAU
);

/*==============================================================*/
/* Index : BIB_IDX_ORDRE                                        */
/*==============================================================*/
create index BIB_IDX_ORDRE on BIBLIOTHEQUE
(
   BIB_ORDRE
);

/*==============================================================*/
/* Index : BIB_IDX_PARENT                                       */
/*==============================================================*/
create index BIB_IDX_PARENT on BIBLIOTHEQUE
(
   BIB_PARENT
);

/*==============================================================*/
/* Table : BINAIRE                                              */
/*==============================================================*/
create table BINAIRE
(
   BIN_ID               int(7) not null auto_increment,
   BIN_OBJET            longblob,
   primary key (BIN_ID)
);

/*==============================================================*/
/* Table : CATEGORIE                                            */
/*==============================================================*/
create table CATEGORIE
(
   CAT_ID               int(7) not null auto_increment,
   CAT_LIBELLE          varchar(30),
   primary key (CAT_ID)
);

/*==============================================================*/
/* Table : CHANTIER                                             */
/*==============================================================*/
create table CHANTIER
(
   CHT_ID               int(7) not null auto_increment,
   primary key (CHT_ID)
);

/*==============================================================*/
/* Table : CHARGEAFFAIRE                                        */
/*==============================================================*/
create table CHARGEAFFAIRE
(
   CHAFF_ID             int(7) not null auto_increment,
   primary key (CHAFF_ID)
);

/*==============================================================*/
/* Table : CIVILITE                                             */
/*==============================================================*/
create table CIVILITE
(
   CIV_ID               int(7) not null auto_increment,
   CIV_LIBELLE          varchar(30),
   primary key (CIV_ID)
);

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
create table CLIENT
(
   CNT_ID               int(7) not null,
   CLI_PROSPECT         bool,
   CLI_MONTANT_PLAFOND  float(8,2),
   primary key (CNT_ID)
);

/*==============================================================*/
/* Table : CODIFICATION                                         */
/*==============================================================*/
create table CODIFICATION
(
   COD_ID               int(7) not null auto_increment,
   COD_TYPE             int,
   COD_FORMATAGE        char(50),
   COD_COMPTEUR         bigint,
   primary key (COD_ID)
);

/*==============================================================*/
/* Table : CONTACT                                              */
/*==============================================================*/
create table CONTACT
(
   CNT_ID               int(7) not null auto_increment,
   BIN_REMARQUES        int(7),
   ACT_ID               int(7),
   BIN_RAPPEL_MOTIF     int(7),
   COO_ID               int(7),
   CAT_ID               int(7),
   CNT_CODE             varchar(25),
   CNT_NOM_SOCIETE      varchar(40),
   CNT_DATE_CREATION    datetime,
   CNT_DATE_MAJ         datetime,
   CNT_CODE_NAF         varchar(6),
   CNT_SIREN            varchar(14),
   CNT_TVA_INTRA        varchar(13),
   CNT_RAPPEL_DATE      datetime,
   CNT_HIDE             bool comment 'Masqué',
   primary key (CNT_ID)
);

/*==============================================================*/
/* Table : COORDONNEECNT                                        */
/*==============================================================*/
create table COORDONNEECNT
(
   COO_ID               int(7) not null auto_increment,
   LOC_ID               int(7),
   PAY_ID               int(7),
   CIV_ID               int(7),
   CNT_ID               int(7),
   COO_NOM              varchar(40),
   COO_PRENOM           varchar(40),
   COO_RUE              varchar(35),
   COO_COMPLEMENTAIRE   varchar(35),
   COO_CP               varchar(10),
   COO_VILLE            varchar(36),
   COO_TEL1             varchar(21),
   COO_TEL2             varchar(21),
   COO_FAX              varchar(21),
   COO_MOBILE           varchar(21),
   COO_MAIL             varchar(69),
   COO_MAIL2            varchar(69),
   COO_WEB              varchar(69),
   primary key (COO_ID)
);

alter table COORDONNEECNT comment 'CoordonneeContact';

/*==============================================================*/
/* Table : DETAILCNT                                            */
/*==============================================================*/
create table DETAILCNT
(
   DET_ID               int(7) not null auto_increment,
   CNT_ID               int(7) not null,
   COO_ID               int(7),
   DET_DEFAUT           bool,
   DET_ORDRE            smallint,
   DET_FONCTION         varchar(40),
   primary key (DET_ID)
);

alter table DETAILCNT comment 'DetailContact';

/*==============================================================*/
/* Table : DEVIS                                                */
/*==============================================================*/
create table DEVIS
(
   AFF_ID               int(7) not null,
   DEV_SOURCE_ID        int(7),
   primary key (AFF_ID)
);

/*==============================================================*/
/* Table : DIVERSCNT                                            */
/*==============================================================*/
create table DIVERSCNT
(
   CNT_ID               int(7) not null,
   primary key (CNT_ID)
);

alter table DIVERSCNT comment 'DiversContact';

/*==============================================================*/
/* Table : ECHEANCIER                                           */
/*==============================================================*/
create table ECHEANCIER
(
   ECH_ID               int(7) not null auto_increment,
   AFF_ID               int(7),
   primary key (ECH_ID)
);

/*==============================================================*/
/* Table : ECHEANCIER_REGLEMENT                                 */
/*==============================================================*/
create table ECHEANCIER_REGLEMENT
(
   ECH_ID               int(7) not null,
   REG_ID               int(7) not null,
   ERG_MONTANT          float(8,2),
   primary key (ECH_ID, REG_ID)
);

/*==============================================================*/
/* Table : ENGIN                                                */
/*==============================================================*/
create table ENGIN
(
   BIB_ID               int(7) not null,
   ENG_IMMATRICULATION  varchar(25),
   ENG_IMMATRICULATION_DATE date,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : ENGIN_BIB                                            */
/*==============================================================*/
create table ENGIN_BIB
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : ENGIN_ETUDE                                          */
/*==============================================================*/
create table ENGIN_ETUDE
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : ETAT                                                 */
/*==============================================================*/
create table ETAT
(
   ETA_ID               int(7) not null auto_increment,
   ETA_LIBELLE          varchar(30),
   primary key (ETA_ID)
);

/*==============================================================*/
/* Table : ETUDE                                                */
/*==============================================================*/
create table ETUDE
(
   ETU_ID               int(7) not null auto_increment,
   TVA_DEFAUT           int(7),
   AFF_ID               int(7) not null,
   ETU_LIBELLE          varchar(30),
   primary key (ETU_ID)
);

/*==============================================================*/
/* Table : FACTURE                                              */
/*==============================================================*/
create table FACTURE
(
   AFF_ID               int(7) not null,
   DEV_ID               int(7),
   primary key (AFF_ID)
);

/*==============================================================*/
/* Table : FAMILLE                                              */
/*==============================================================*/
create table FAMILLE
(
   FAM_ID               int(7) not null auto_increment,
   FAM_TYPE             smallint,
   FAM_ORDRE            numeric(7,0),
   FAM_BORNE_GAUCHE     numeric(7,0) not null comment 'Borne gauche',
   FAM_BORNE_DROITE     numeric(7,0) not null comment 'Borne droite',
   FAM_NIVEAU           numeric(7,0) not null comment 'Niveau (0 : racine, 1 niveau 1er, ...)',
   FAM_PARENT           numeric(7,0) comment 'Sueper parent id',
   FAM_DESCRIPTIF       varchar(100),
   primary key (FAM_ID)
);

/*==============================================================*/
/* Index : FAM_IDX_BORNE_GAUCHE                                 */
/*==============================================================*/
create index FAM_IDX_BORNE_GAUCHE on FAMILLE
(
   FAM_BORNE_GAUCHE
);

/*==============================================================*/
/* Index : FAM_IDX_BORNE_DROITE                                 */
/*==============================================================*/
create index FAM_IDX_BORNE_DROITE on FAMILLE
(
   FAM_BORNE_DROITE
);

/*==============================================================*/
/* Index : FAM_IDX_NIVEAU                                       */
/*==============================================================*/
create index FAM_IDX_NIVEAU on FAMILLE
(
   FAM_NIVEAU
);

/*==============================================================*/
/* Index : FAM_IDX_ORDRE                                        */
/*==============================================================*/
create index FAM_IDX_ORDRE on FAMILLE
(
   FAM_ORDRE
);

/*==============================================================*/
/* Index : FAM_IDX_PARENT                                       */
/*==============================================================*/
create index FAM_IDX_PARENT on FAMILLE
(
   FAM_PARENT
);

/*==============================================================*/
/* Index : FAM_IDX_GAU_DRO_PAR                                  */
/*==============================================================*/
create index FAM_IDX_GAU_DRO_PAR on FAMILLE
(
   FAM_BORNE_GAUCHE,
   FAM_BORNE_DROITE,
   FAM_PARENT
);

/*==============================================================*/
/* Table : FOURNISSEUR                                          */
/*==============================================================*/
create table FOURNISSEUR
(
   CNT_ID               int(7) not null,
   primary key (CNT_ID)
);

/*==============================================================*/
/* Table : FOURNISSEUR_MATERIAUX                                */
/*==============================================================*/
create table FOURNISSEUR_MATERIAUX
(
   BIB_ID               int(7) not null,
   CNT_ID               int(7) not null,
   FRNMX_PRIX_TARIF     float(8,2),
   FRNMX_REMISE         numeric(5,2),
   FRNMX_QTE_MINI       numeric(9,3),
   primary key (BIB_ID, CNT_ID)
);

/*==============================================================*/
/* Table : GROUPECNT                                            */
/*==============================================================*/
create table GROUPECNT
(
   GRP_ID               int(7) not null auto_increment,
   GRP_LIBELLE          varchar(30),
   primary key (GRP_ID)
);

alter table GROUPECNT comment 'GroupeContact';

/*==============================================================*/
/* Table : GROUPECNT_DIVERSCNT                                  */
/*==============================================================*/
create table GROUPECNT_DIVERSCNT
(
   CNT_ID               int(7) not null,
   GRP_ID               int(7) not null,
   primary key (CNT_ID, GRP_ID)
);

/*==============================================================*/
/* Table : IMAGE                                                */
/*==============================================================*/
create table IMAGE
(
   IMG_ID               int(7) not null auto_increment,
   IMG_OBJET            longblob,
   primary key (IMG_ID)
);

/*==============================================================*/
/* Table : LOCALISATION                                         */
/*==============================================================*/
create table LOCALISATION
(
   LOC_ID               int(7) not null auto_increment,
   LOC_LIBELLE          varchar(30),
   primary key (LOC_ID)
);

/*==============================================================*/
/* Table : MAINOEUVRE                                           */
/*==============================================================*/
create table MAINOEUVRE
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : MAINOEUVRE_BIB                                       */
/*==============================================================*/
create table MAINOEUVRE_BIB
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : MAINOEUVRE_ETUDE                                     */
/*==============================================================*/
create table MAINOEUVRE_ETUDE
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : MATERIAUX                                            */
/*==============================================================*/
create table MATERIAUX
(
   BIB_ID               int(7) not null,
   FRN_DEFAUT           int(7),
   MX_PRIX_TARIF        float(8,2),
   MX_REMISE            numeric(5,2),
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : MATERIAUX_BIB                                        */
/*==============================================================*/
create table MATERIAUX_BIB
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : MATERIAUX_ETUDE                                      */
/*==============================================================*/
create table MATERIAUX_ETUDE
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : MODE_PAIEMENT                                        */
/*==============================================================*/
create table MODE_PAIEMENT
(
   MP_ID                int(7) not null auto_increment,
   MP_LIBELLE           varchar(30),
   primary key (MP_ID)
);

/*==============================================================*/
/* Table : PAYS                                                 */
/*==============================================================*/
create table PAYS
(
   PAY_ID               int(7) not null auto_increment,
   PAY_LIBELLE          varchar(30),
   primary key (PAY_ID)
);

/*==============================================================*/
/* Table : PREFERENCE                                           */
/*==============================================================*/
create table PREFERENCE
(
   PRE_ID               int(7) not null auto_increment,
   primary key (PRE_ID)
);

/*==============================================================*/
/* Table : REGLEMENT                                            */
/*==============================================================*/
create table REGLEMENT
(
   REG_ID               int(7) not null auto_increment,
   MP_ID                int(7) not null,
   REG_CODE             varchar(30),
   REG_DESCRIPTIF       varchar(40),
   REG_DATE_PAIEMENT    date,
   REG_BANQUE           varchar(30),
   REG_NUM_CHEQUE       varchar(30),
   primary key (REG_ID)
);

/*==============================================================*/
/* Table : SITUATION                                            */
/*==============================================================*/
create table SITUATION
(
   AFF_ID               int(7) not null,
   DEV_ID               int(7) not null,
   primary key (AFF_ID)
);

/*==============================================================*/
/* Table : SKIN                                                 */
/*==============================================================*/
create table SKIN
(
   SKI_ID               int(7) not null auto_increment,
   primary key (SKI_ID)
);

/*==============================================================*/
/* Table : SOUSTRAITANT                                         */
/*==============================================================*/
create table SOUSTRAITANT
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : SOUSTRAITANT_BIB                                     */
/*==============================================================*/
create table SOUSTRAITANT_BIB
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : SOUSTRAITANT_ETUDE                                   */
/*==============================================================*/
create table SOUSTRAITANT_ETUDE
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : TACHE_LOT                                            */
/*==============================================================*/
create table TACHE_LOT
(
   BIB_ID               int(7) not null,
   TAC_PRIX_VENTE_FIXE  bool,
   TAC_BENEFICE_MX      numeric(6,3),
   TAC_FRAIS_GENERAUX_MX numeric(6,3),
   TAC_BENEFICE_MO      numeric(6,3),
   TAC_FRAIS_GENERAUX_MO numeric(6,3),
   TAC_BENEFICE_ST      numeric(6,3),
   TAC_FRAIS_GENERAUX_ST numeric(6,3),
   TAC_BENEFICE_ENG     numeric(6,3),
   TAC_FRAIS_GENERAUX_ENG numeric(6,3),
   TAC_IS_LOT           bool not null comment 'TRUE pour un Lot, FALSE pour une tâche',
   primary key (BIB_ID)
);

/*==============================================================*/
/* Index : TACHE_LOT_IDX_IS_LOT                                 */
/*==============================================================*/
create index TACHE_LOT_IDX_IS_LOT on TACHE_LOT
(
   TAC_IS_LOT
);

/*==============================================================*/
/* Table : TACHE_LOT_BIB                                        */
/*==============================================================*/
create table TACHE_LOT_BIB
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : TACHE_LOT_ETUDE                                      */
/*==============================================================*/
create table TACHE_LOT_ETUDE
(
   BIB_ID               int(7) not null,
   primary key (BIB_ID)
);

/*==============================================================*/
/* Table : TVA                                                  */
/*==============================================================*/
create table TVA
(
   TVA_ID               int(7) not null auto_increment,
   TVA_TAUX             numeric(5,2),
   TVA_HIDE             bool comment 'Masqué',
   TVA_LIBELLE          varchar(30),
   primary key (TVA_ID)
);

/*==============================================================*/
/* Table : UNITE                                                */
/*==============================================================*/
create table UNITE
(
   UTE_ID               int(7) not null auto_increment,
   UTE                  char(5),
   primary key (UTE_ID)
);

alter table ACOMPTE add constraint FK_RELATION_67 foreign key (DEV_ID)
      references DEVIS (AFF_ID) on delete restrict on update restrict;

alter table ACOMPTE add constraint FK_RELATION_94 foreign key (AFF_ID)
      references AFFAIRE (AFF_ID) on delete restrict on update restrict;

alter table AFFAIRE add constraint FK_RELATION_100 foreign key (BIN_INTRODUCTION)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table AFFAIRE add constraint FK_RELATION_101 foreign key (BIN_CONCLUSION)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table AFFAIRE add constraint FK_RELATION_102 foreign key (BIN_METRE)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table AFFAIRE add constraint FK_RELATION_65 foreign key (CHT_ID)
      references CHANTIER (CHT_ID) on delete restrict on update restrict;

alter table AFFAIRE add constraint FK_RELATION_76 foreign key (ETA_ID)
      references ETAT (ETA_ID) on delete restrict on update restrict;

alter table AFFAIRE add constraint FK_RELATION_84 foreign key (BIN_DESCRIPTIF)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table AFFAIRE add constraint FK_RELATION_9 foreign key (CNT_ID)
      references CLIENT (CNT_ID) on delete restrict on update restrict;

alter table AFFAIRE add constraint FK_RELATION_99 foreign key (BIN_NOTES)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table AVOIR add constraint FK_RELATION_121 foreign key (FAC_ID)
      references FACTURE (AFF_ID) on delete restrict on update restrict;

alter table AVOIR add constraint FK_RELATION_93 foreign key (AFF_ID)
      references AFFAIRE (AFF_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_LIEN_BIB_ORIGIN foreign key (BIB_ORIGIN)
      references BIBLIOTHEQUE (BIB_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_RELATION_103 foreign key (BIN_DESCRIPTIF)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_RELATION_104 foreign key (BIN_DESC_COMMERCIAL)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_RELATION_105 foreign key (BIN_DESC_TECHINIQUE)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_RELATION_106 foreign key (BIN_NOTES)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_RELATION_107 foreign key (IMG_IMAGE)
      references IMAGE (IMG_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_RELATION_63 foreign key (FAM_ID)
      references FAMILLE (FAM_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_RELATION_68 foreign key (TVA_ID)
      references TVA (TVA_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_RELATION_69 foreign key (ETU_ID)
      references ETUDE (ETU_ID) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_RELATION_80 foreign key (BIN_METRE)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table CLIENT add constraint FK_RELATION_97 foreign key (CNT_ID)
      references CONTACT (CNT_ID) on delete restrict on update restrict;

alter table CONTACT add constraint FK_RELATION_11 foreign key (COO_ID)
      references COORDONNEECNT (COO_ID) on delete restrict on update restrict;

alter table CONTACT add constraint FK_RELATION_71 foreign key (ACT_ID)
      references ACTIVITE (ACT_ID) on delete restrict on update restrict;

alter table CONTACT add constraint FK_RELATION_74 foreign key (CAT_ID)
      references CATEGORIE (CAT_ID) on delete restrict on update restrict;

alter table CONTACT add constraint FK_RELATION_82 foreign key (BIN_REMARQUES)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table CONTACT add constraint FK_RELATION_83 foreign key (BIN_RAPPEL_MOTIF)
      references BINAIRE (BIN_ID) on delete restrict on update restrict;

alter table COORDONNEECNT add constraint FK_RELATION_10 foreign key (CNT_ID)
      references CLIENT (CNT_ID) on delete restrict on update restrict;

alter table COORDONNEECNT add constraint FK_RELATION_70 foreign key (CIV_ID)
      references CIVILITE (CIV_ID) on delete restrict on update restrict;

alter table COORDONNEECNT add constraint FK_RELATION_72 foreign key (PAY_ID)
      references PAYS (PAY_ID) on delete restrict on update restrict;

alter table COORDONNEECNT add constraint FK_RELATION_73 foreign key (LOC_ID)
      references LOCALISATION (LOC_ID) on delete restrict on update restrict;

alter table DETAILCNT add constraint FK_RELATION_15 foreign key (CNT_ID)
      references CONTACT (CNT_ID) on delete restrict on update restrict;

alter table DETAILCNT add constraint FK_RELATION_77 foreign key (COO_ID)
      references COORDONNEECNT (COO_ID) on delete restrict on update restrict;

alter table DEVIS add constraint FK_RELATION_122 foreign key (DEV_SOURCE_ID)
      references DEVIS (AFF_ID) on delete restrict on update restrict;

alter table DEVIS add constraint FK_RELATION_90 foreign key (AFF_ID)
      references AFFAIRE (AFF_ID) on delete restrict on update restrict;

alter table DIVERSCNT add constraint FK_RELATION_96 foreign key (CNT_ID)
      references CONTACT (CNT_ID) on delete restrict on update restrict;

alter table ECHEANCIER add constraint FK_RELATION_39 foreign key (AFF_ID)
      references AFFAIRE (AFF_ID) on delete restrict on update restrict;

alter table ECHEANCIER_REGLEMENT add constraint FK_RELATION_78 foreign key (ECH_ID)
      references ECHEANCIER (ECH_ID) on delete restrict on update restrict;

alter table ECHEANCIER_REGLEMENT add constraint FK_RELATION_79 foreign key (REG_ID)
      references REGLEMENT (REG_ID) on delete restrict on update restrict;

alter table ENGIN add constraint FK_RELATION_41 foreign key (BIB_ID)
      references BIBLIOTHEQUE (BIB_ID) on delete restrict on update restrict;

alter table ENGIN_BIB add constraint FK_RELATION_111 foreign key (BIB_ID)
      references ENGIN (BIB_ID) on delete restrict on update restrict;

alter table ENGIN_ETUDE add constraint FK_RELATION_112 foreign key (BIB_ID)
      references ENGIN (BIB_ID) on delete restrict on update restrict;

alter table ETUDE add constraint FK_RELATION_6 foreign key (AFF_ID)
      references AFFAIRE (AFF_ID) on delete restrict on update restrict;

alter table ETUDE add constraint FK_RELATION_66 foreign key (TVA_DEFAUT)
      references TVA (TVA_ID) on delete restrict on update restrict;

alter table FACTURE add constraint FK_RELATION_60 foreign key (DEV_ID)
      references DEVIS (AFF_ID) on delete restrict on update restrict;

alter table FACTURE add constraint FK_RELATION_91 foreign key (AFF_ID)
      references AFFAIRE (AFF_ID) on delete restrict on update restrict;

alter table FOURNISSEUR add constraint FK_RELATION_95 foreign key (CNT_ID)
      references CONTACT (CNT_ID) on delete restrict on update restrict;

alter table FOURNISSEUR_MATERIAUX add constraint FK_RELATION_81 foreign key (CNT_ID)
      references FOURNISSEUR (CNT_ID) on delete restrict on update restrict;

alter table FOURNISSEUR_MATERIAUX add constraint FK_RELATION_98 foreign key (BIB_ID)
      references MATERIAUX (BIB_ID) on delete restrict on update restrict;

alter table GROUPECNT_DIVERSCNT add constraint FK_GROUPECNT_DIVERSCNT foreign key (CNT_ID)
      references DIVERSCNT (CNT_ID) on delete restrict on update restrict;

alter table GROUPECNT_DIVERSCNT add constraint FK_GROUPECNT_DIVERSCNT2 foreign key (GRP_ID)
      references GROUPECNT (GRP_ID) on delete restrict on update restrict;

alter table MAINOEUVRE add constraint FK_RELATION_44 foreign key (BIB_ID)
      references BIBLIOTHEQUE (BIB_ID) on delete restrict on update restrict;

alter table MAINOEUVRE_BIB add constraint FK_RELATION_110 foreign key (BIB_ID)
      references MAINOEUVRE (BIB_ID) on delete restrict on update restrict;

alter table MAINOEUVRE_ETUDE add constraint FK_RELATION_109 foreign key (BIB_ID)
      references MAINOEUVRE (BIB_ID) on delete restrict on update restrict;

alter table MATERIAUX add constraint FK_RELATION_25 foreign key (FRN_DEFAUT)
      references FOURNISSEUR (CNT_ID) on delete restrict on update restrict;

alter table MATERIAUX add constraint FK_RELATION_42 foreign key (BIB_ID)
      references BIBLIOTHEQUE (BIB_ID) on delete restrict on update restrict;

alter table MATERIAUX_BIB add constraint FK_RELATION_119 foreign key (BIB_ID)
      references MATERIAUX (BIB_ID) on delete restrict on update restrict;

alter table MATERIAUX_ETUDE add constraint FK_RELATION_120 foreign key (BIB_ID)
      references MATERIAUX (BIB_ID) on delete restrict on update restrict;

alter table REGLEMENT add constraint FK_RELATION_75 foreign key (MP_ID)
      references MODE_PAIEMENT (MP_ID) on delete restrict on update restrict;

alter table SITUATION add constraint FK_RELATION_61 foreign key (DEV_ID)
      references DEVIS (AFF_ID) on delete restrict on update restrict;

alter table SITUATION add constraint FK_RELATION_92 foreign key (AFF_ID)
      references AFFAIRE (AFF_ID) on delete restrict on update restrict;

alter table SOUSTRAITANT add constraint FK_RELATION_45 foreign key (BIB_ID)
      references BIBLIOTHEQUE (BIB_ID) on delete restrict on update restrict;

alter table SOUSTRAITANT_BIB add constraint FK_RELATION_113 foreign key (BIB_ID)
      references SOUSTRAITANT (BIB_ID) on delete restrict on update restrict;

alter table SOUSTRAITANT_ETUDE add constraint FK_RELATION_114 foreign key (BIB_ID)
      references SOUSTRAITANT (BIB_ID) on delete restrict on update restrict;

alter table TACHE_LOT add constraint FK_RELATION_48 foreign key (BIB_ID)
      references BIBLIOTHEQUE (BIB_ID) on delete restrict on update restrict;

alter table TACHE_LOT_BIB add constraint FK_RELATION_117 foreign key (BIB_ID)
      references TACHE_LOT (BIB_ID) on delete restrict on update restrict;

alter table TACHE_LOT_ETUDE add constraint FK_RELATION_118 foreign key (BIB_ID)
      references TACHE_LOT (BIB_ID) on delete restrict on update restrict;

