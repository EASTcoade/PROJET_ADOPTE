-- Nettoyages
DELETE FROM reception;
ALTER TABLE reception ALTER COLUMN rec_id RESTART WITH 1;

DELETE FROM chat;
ALTER TABLE chat ALTER COLUMN cha_id RESTART WITH 1;

DELETE FROM leader;
ALTER TABLE leader ALTER COLUMN lea_id RESTART WITH 1;

DELETE FROM son;
ALTER TABLE son ALTER COLUMN son_id RESTART WITH 1;


DELETE FROM instrument;
ALTER TABLE instrument ALTER COLUMN ins_id RESTART WITH 1;


DELETE FROM utilisateur;
ALTER TABLE utilisateur ALTER COLUMN uti_id RESTART WITH 1;

DELETE FROM image;
ALTER TABLE image ALTER COLUMN ima_id RESTART WITH 1;

DELETE FROM stylemusical;
ALTER TABLE stylemusical ALTER COLUMN sty_id RESTART WITH 1;





DELETE FROM notification;
ALTER TABLE notification ALTER COLUMN not_id RESTART WITH 1;

DELETE FROM admin;
ALTER TABLE admin ALTER COLUMN adm_id RESTART WITH 1;

DELETE FROM groupe;
ALTER TABLE groupe ALTER COLUMN gro_id RESTART WITH 1;


INSERT into utilisateur (uti_mdp, uti_nom, uti_prenom, uti_pseudo, uti_date_naissance, uti_adresse, uti_tel, uti_niveau, uti_mail)
VALUES 
('1234', 'Dupont', 'Bernard', 'Bebert_du_65', '1945-02-28', '6 rue des Capucins, Boulogne Billancourt', '0285904513', 1, 'beber.dupont@gmail.com'),
('1234', 'Duval', 'Bianca', 'Bibine_la_sauvageonne', '1945-10-12', '25 rue des Capucins, Boulogne Billancourt', '0285904513', 1, 'bibine.duval@gmail.com');


INSERT into stylemusical (sty_nom)
VALUES
('rock'),
('rap'),
('RNB'),
('jazz');

INSERT into groupe (gro_nom)
VALUES 
('gronom1'),
('gronom2');


INSERT into son (son_nom, son_uti_id, son_format)
VALUES 
('mon premier son', 1,'MP3'),
('mon super son', 1,'MP3');

INSERT into image (ima_nom, ima_contenu , ima_format)
VALUES ('image1','01010111100lolilol','JPG'),
('image2','025215412100lolilol','JPG'),
('image3','02541541100lolilol','JPG');

INSERT into instrument (ins_nom, ins_image_id)
VALUES ('guitare',1),
('chant',2);

INSERT into admin (adm_nom, adm_password)
VALUES ('nom1','password1'),
('nom2','password2')
;
INSERT into chat (cha_contenu, cha_uti_id_exp)
VALUES 
('Mon premier message', 1),
('Mon deuxième message', 1);


INSERT into notification (not_msg)
VALUES
('Première notification'),
('Deuxième notification');


INSERT into leader (lea_utilisateur_id)
VALUES
(1),
(1);
