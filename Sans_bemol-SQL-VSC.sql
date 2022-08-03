--CREATE DATABASE Sans_bemol;

CREATE TABLE utilisateur (
    utl_id SERIAL PRIMARY KEY,
    utl_mdp VARCHAR(100) NOT NULL,
    utl_nom VARCHAR(100) NOT NULL,
    utl_prenom VARCHAR(100) NOT NULL,
    utl_pseudo VARCHAR(100) NOT NULL UNIQUE,
    utl_dtnaissance DATE NOT NULL,
    utl_adresse VARCHAR(100) NOT NULL,
    utl_tel VARCHAR(20) NOT NULL, --alter table nom_table ADD CONSTRAINT -- CHECK (-- ~ '[0-9]{10}');
    utl_niveau VARCHAR(20) NOT NULL
);

CREATE TABLE styleMusical (

    sty_id SERIAL PRIMARY KEY,
    sty_nom VARCHAR(20) NOT NULL

);

CREATE TABLE lien_sty_uti(

    styutl_id SERIAL PRIMARY KEY, 
    styutl_utl_id INT,
    styutl_sty_id INT,

    CONSTRAINT fk_styutl_utl_id
    FOREIGN KEY (styutl_utl_id) REFERENCES  utilisateur(utl_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE, 


    CONSTRAINT fk_styutl_sty_id
    FOREIGN KEY (styutl_sty_id) REFERENCES  stylemusical(sty_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);

CREATE TABLE instrument(

    inst_id SERIAL PRIMARY KEY,
    inst_nom VARCHAR(50) NOT NULL
    --inst_image 
);

CREATE TABLE lien_uti_instru(

    utlinst_id SERIAL PRIMARY KEY, 
    utlinst_instru_id INT,
    utlinst_utl_id INT,

    CONSTRAINT fk_utlinst_utl_id
    FOREIGN KEY (utlinst_utl_id) REFERENCES  utilisateur(utl_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE, 


    CONSTRAINT  fk_utlinst_instru_id
    FOREIGN KEY (utlinst_instru_id) REFERENCES  instrument(inst_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);



CREATE TABLE son(

    son_id SERIAL PRIMARY KEY,
    son_nom VARCHAR(50) NOT NULL,
    son_utl_id INT,
    son_contenu BYTEA, 
    --inst_image 

    CONSTRAINT  fk_son_utl_id
    FOREIGN KEY (son_utl_id) REFERENCES utilisateur(utl_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


CREATE TABLE chat(
    chat_recu VARCHAR(1000),
    chat_send VARCHAR(1000),
    chat_date DATE,
    chat_utl_id INT,

    CONSTRAINT fk_chat_utl_id
    FOREIGN KEY (chat_utl_id) REFERENCES utilisateur(utl_id)
);