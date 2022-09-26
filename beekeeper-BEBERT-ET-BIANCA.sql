--Attention table plus a jour: remplacer utl par uti, les inst par ins, chat par cha!!!

INSERT into utilisateur (uti_mdp, uti_nom, uti_prenom, uti_pseudo, uti_date_naissance, uti_adresse, uti_tel, uti_niveau, uti_mail)
VALUES ('1234', 'Dupont', 'Bernard', 'Bebert_du_65', '1945/02/28', '6 rue des Capucins, Boulogne Billancourt', '0285904513',1, 'beber.dupont@gmail.com');
;
INSERT into utilisateur (uti_mdp, uti_nom, uti_prenom, uti_pseudo, uti_date_naissance, uti_adresse, uti_tel, uti_niveau, uti_mail)
VALUES ('1234', 'Duval', 'Bianca', 'Bibine_la_sauvageonne', '1945/10/12', '25 rue des Capucins, Boulogne Billancourt', '0285904513',1, 'bibine.duval@gmail.com');
;

SELECT * FROM utilisateur;

INSERT into stylemusical (sty_nom)
VALUES ('rock')

INSERT into son (son_nom, son_uti_id, son_format)
VALUES ('mon premier son', 1,'MP3');

INSERT into instrument (ins_nom)
VALUES ('guitare'),
('chant'),
('triangle');


pg_read_file

select pg_read_binary_file('C:\Users\etien\Downloads\Carte-aux-Adieux\Carte aux Adieux.mp3')::bytea
UPDATE son SET son_contenu = (select pg_read_binary_file('C:\Users\etien\Downloads\Carte-aux-Adieux\Carte aux Adieux.mp3')::bytea)