-- Nettoyages
DELETE FROM utilisateur;
ALTER TABLE utilisateur ALTER COLUMN uti_id RESTART WITH 1;

DELETE FROM stylemusical;
ALTER TABLE stylemusical ALTER COLUMN sty_id RESTART WITH 1;

DELETE FROM son;
ALTER TABLE son ALTER COLUMN son_id RESTART WITH 1;

DELETE FROM instrument;
ALTER TABLE instrument ALTER COLUMN ins_id RESTART WITH 1;

DELETE FROM chat;
ALTER TABLE chat ALTER COLUMN cha_id RESTART WITH 1;

DELETE FROM notification;
ALTER TABLE notification ALTER COLUMN not_id RESTART WITH 1;

DELETE FROM leader;
ALTER TABLE leader ALTER COLUMN lea_id RESTART WITH 1;


INSERT into utilisateur (uti_mdp, uti_nom, uti_prenom, uti_pseudo, uti_datnaissance, uti_adresse, uti_tel, uti_niveau, uti_mail)
VALUES 
('1234', 'Dupont', 'Bernard', 'Bebert_du_65', '1945/02/28', '6 rue des Capucins, Boulogne Billancourt', '0285904513', 'debutant', 'beber.dupont@gmail.com'),
('1234', 'Duval', 'Bianca', 'Bibine_la_sauvageonne', '1945/10/12', '25 rue des Capucins, Boulogne Billancourt', '0285904513', 'debutant', 'bibine.duval@gmail.com');


INSERT into stylemusical (sty_nom)
VALUES
('rock'),
('rap');


INSERT into son (son_nom, son_uti_id, son_format)
VALUES 
('mon premier son', 1,'MP3'),
('mon super son', 2,'MP3');


INSERT into instrument (ins_nom)
VALUES ('guitare'),
('chant'),
('triangle');


INSERT into chat (cha_contenu, cha_uti_id_exp)
VALUES 
('Mon premier message', 1),
('Mon deuxième message', 2);


INSERT into notification (not_msg)
VALUES
('Première notification'),
('Deuxième notification');


INSERT into leader (lea_utilisateur_id)
VALUES
(1),
(2);
