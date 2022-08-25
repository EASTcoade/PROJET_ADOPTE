--CREATE DATABASE Sans_bemol;

CREATE TABLE utilisateur (
    uti_id SERIAL PRIMARY KEY,
    uti_mdp VARCHAR(100) NOT NULL,
    uti_nom VARCHAR(100) NOT NULL,
    uti_prenom VARCHAR(100) NOT NULL,
    uti_pseudo VARCHAR(100) NOT NULL UNIQUE,
    uti_date_naissance DATE NOT NULL,
    uti_adresse VARCHAR(100) NOT NULL,
    uti_tel VARCHAR(20) NOT NULL, --alter table nom_table ADD CONSTRAINT -- CHECK (-- ~ '[0-9]{10}');
    uti_niveau VARCHAR(20) NOT NULL
);

CREATE TABLE styleMusical (

    sty_id SERIAL PRIMARY KEY,
    sty_nom VARCHAR(20) NOT NULL

);

CREATE TABLE lien_sty_uti(

    styuti_id SERIAL PRIMARY KEY, 
    styuti_uti_id INT,
    styuti_sty_id INT,

    CONSTRAINT fk_styuti_uti_id
    FOREIGN KEY (styuti_uti_id) REFERENCES  utilisateur(uti_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE, 


    CONSTRAINT fk_styuti_sty_id
    FOREIGN KEY (styuti_sty_id) REFERENCES  stylemusical(sty_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);

CREATE TABLE instrument(

    ins_id SERIAL PRIMARY KEY,
    ins_nom VARCHAR(50) NOT NULL
    --ins_image 
);

CREATE TABLE lien_uti_ins(

    utiins_id SERIAL PRIMARY KEY, 
    utiins_ins_id INT,
    utiins_uti_id INT,

    CONSTRAINT fk_utiins_uti_id
    FOREIGN KEY (utiins_uti_id) REFERENCES  utilisateur(uti_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE, 


    CONSTRAINT  fk_utiins_ins_id
    FOREIGN KEY (utiins_ins_id) REFERENCES  instrument(ins_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);



CREATE TABLE son(

    son_id SERIAL PRIMARY KEY,
    son_nom VARCHAR(50) NOT NULL,
    son_uti_id INT,
    son_contenu BYTEA, 
    --inst_image 

    CONSTRAINT  fk_son_uti_id
    FOREIGN KEY (son_uti_id) REFERENCES utilisateur(uti_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


CREATE TABLE chat(
    cha_recu VARCHAR(1000),
    cha_envoye VARCHAR(1000),
    cha_date DATE,
    cha_uti_id INT,

    CONSTRAINT fk_chat_uti_id
    FOREIGN KEY (chat_uti_id) REFERENCES utilisateur(uti_id)
);