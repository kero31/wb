/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  30/10/2014 17:31:55                      */
/*==============================================================*/


drop view if exists V_CONNECTIONDB;

drop view if exists V_SCRIPTUPDATE;

SET foreign_key_checks = 0;
drop table if exists CONNECTIONDB;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists PROJECT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists PROJECTSCRIPT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists ROLE;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists USERAPPLI;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists USERPROJECT;
SET foreign_key_checks = 1;

SET foreign_key_checks = 0;
drop table if exists USERROLE;
SET foreign_key_checks = 1;

/*==============================================================*/
/* Table : CONNECTIONDB                                         */
/*==============================================================*/
create table CONNECTIONDB
(
   CON_ID               int(7) not null auto_increment,
   CON_DRIVER           text,
   CON_URL              text,
   CON_DIALECT          text,
   CON_LIMIT_USER_ALERT int,
   CON_ROOT_LOGIN       text,
   CON_ROOT_PASSWORD    text,
   CON_ROOT_DBNAME      text,
   CON_ENABLED          bool,
   primary key (CON_ID)
);

/*==============================================================*/
/* Table : PROJECT                                              */
/*==============================================================*/
create table PROJECT
(
   PRO_ID               int(7) not null auto_increment,
   PRO_NAME             text,
   PRO_CODE             text,
   primary key (PRO_ID)
);

/*==============================================================*/
/* Table : PROJECTSCRIPT                                        */
/*==============================================================*/
create table PROJECTSCRIPT
(
   PSR_ID               int(7) not null auto_increment,
   PRO_ID               int(7) not null,
   PSR_FILE_NAME        text,
   primary key (PSR_ID)
);

/*==============================================================*/
/* Table : ROLE                                                 */
/*==============================================================*/
create table ROLE
(
   ROL_ID               int(7) not null auto_increment,
   PRO_ID               int(7),
   ROL_CODE             text,
   primary key (ROL_ID)
);

/*==============================================================*/
/* Table : USERAPPLI                                            */
/*==============================================================*/
create table USERAPPLI
(
   USE_ID               int(7) not null auto_increment,
   USE_PARENT           int(7),
   USE_USERNAME         text,
   USE_PASSWORD         text,
   USE_MAIL             text,
   USE_DATE_CREATE      datetime,
   USE_DATE_EXPIRED     datetime,
   USE_LOCKED           bool,
   primary key (USE_ID)
);

/*==============================================================*/
/* Table : USERPROJECT                                          */
/*==============================================================*/
create table USERPROJECT
(
   USE_ID               int(7) not null,
   PRO_ID               int(7) not null,
   PSR_ID               int(7),
   CON_ID               int(7),
   USP_BD_LOGIN         text,
   USP_BD_PASSWORD      text,
   USP_BD_DBNAME        text,
   primary key (USE_ID, PRO_ID)
);

/*==============================================================*/
/* Table : USERROLE                                             */
/*==============================================================*/
create table USERROLE
(
   USE_ID               int(7) not null,
   ROL_ID               int(7) not null,
   primary key (USE_ID, ROL_ID)
);

/*==============================================================*/
/* Vue : V_CONNECTIONDB                                         */
/*==============================================================*/
create or replace view V_CONNECTIONDB as
select c.*, (CON_LIMIT_USER_ALERT - (select count(*) from USERPROJECT u where  u.CON_ID = c.CON_ID)) as NB_USER_RESTANT 
from CONNECTIONDB c where c.CON_ENABLED=1;

/*==============================================================*/
/* Vue : V_SCRIPTUPDATE                                         */
/*==============================================================*/
create or replace view V_SCRIPTUPDATE as
select concat(CON_URL,USP_BD_DBNAME) as URL, CON_DRIVER as DRIVER, CON_ROOT_LOGIN as LOGIN, 
    CON_ROOT_PASSWORD as PASSWORD, PSR_FILE_NAME as FILENAME, PROJECT.PRO_ID as PROJECT_ID, 
    USERAPPLI.USE_ID as USERAPPLI_ID, PROJECTSCRIPT.PSR_ID as PROJECTSCRIPT_ID
 from USERPROJECT 
  inner join CONNECTIONDB ON USERPROJECT.CON_ID = CONNECTIONDB.CON_ID
  inner join PROJECT ON USERPROJECT.PRO_ID = PROJECT.PRO_ID
  inner join PROJECTSCRIPT on PROJECTSCRIPT.PRO_ID = PROJECT.PRO_ID
  inner join USERAPPLI on USERAPPLI.USE_ID = USERPROJECT.USE_ID
  where USERPROJECT.PSR_ID < PROJECTSCRIPT.PSR_ID
  order by USERAPPLI.USE_ID, PROJECTSCRIPT.PSR_ID;

alter table PROJECTSCRIPT add constraint FK_RELATION_7 foreign key (PRO_ID)
      references PROJECT (PRO_ID) on delete restrict on update restrict;

alter table ROLE add constraint FK_RELATION_3 foreign key (PRO_ID)
      references PROJECT (PRO_ID) on delete restrict on update restrict;

alter table USERAPPLI add constraint FK_LIEN_USE_PARENT foreign key (USE_PARENT)
      references USERAPPLI (USE_ID) on delete restrict on update restrict;

alter table USERPROJECT add constraint FK_RELATION_5 foreign key (USE_ID)
      references USERAPPLI (USE_ID) on delete restrict on update restrict;

alter table USERPROJECT add constraint FK_RELATION_6 foreign key (PRO_ID)
      references PROJECT (PRO_ID) on delete restrict on update restrict;

alter table USERPROJECT add constraint FK_RELATION_8 foreign key (PSR_ID)
      references PROJECTSCRIPT (PSR_ID) on delete restrict on update restrict;

alter table USERPROJECT add constraint FK_RELATION_9 foreign key (CON_ID)
      references CONNECTIONDB (CON_ID) on delete restrict on update restrict;

alter table USERROLE add constraint FK_USERROLE foreign key (USE_ID)
      references USERAPPLI (USE_ID) on delete restrict on update restrict;

alter table USERROLE add constraint FK_USERROLE2 foreign key (ROL_ID)
      references ROLE (ROL_ID) on delete restrict on update restrict;

