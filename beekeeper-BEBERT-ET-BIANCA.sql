INSERT into utilisateur (utl_mdp, utl_nom, utl_prenom, utl_pseudo, utl_dtnaissance, utl_adresse, utl_tel, utl_niveau)
VALUES ('1234', 'Dupont', 'Bernard', 'Bebert_du_65', '1945/02/28', '6 rue des Capucins, Boulogne Billancourt', '0285904513', 'debutant');
;
INSERT into utilisateur (utl_mdp, utl_nom, utl_prenom, utl_pseudo, utl_dtnaissance, utl_adresse, utl_tel, utl_niveau)
VALUES ('1234', 'Duval', 'Bianca', 'Bibine_la_sauvageonne', '1945/10/12', '25 rue des Capucins, Boulogne Billancourt', '0285904513', 'debutant');
;

SELECT * FROM utilisateur;

INSERT into stylemusical (sty_nom)
VALUES ('rock')

INSERT into son (son_nom, son_utl_id)
VALUES ('mon premier son', 3);

INSERT into instrument (inst_nom)
VALUES ('guitare');

INSERT into instrument (inst_nom)
VALUES ('chant'),
('triangle');

INSERT into stylemusical (sty_nom)
VALUES ('musique de chambre')

INSERT into lien_uti_instru (utlinst_instru_id, utlinst_utl_id)
Values (1, 1);

INSERT into lien_sty_uti (styutl_utl_id, styutl_sty_id)
Values (1, 1);

pg_read_file

select pg_read_binary_file('C:\Users\etien\Downloads\Carte-aux-Adieux\Carte aux Adieux.mp3')::bytea
UPDATE son SET son_contenu = (select pg_read_binary_file('C:\Users\etien\Downloads\Carte-aux-Adieux\Carte aux Adieux.mp3')::bytea)