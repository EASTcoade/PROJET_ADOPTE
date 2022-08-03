CREATE DATABASE Sans_bemol
CREATE TABLE utilisateur (
    utl_id SERIAL PRIMARY KEY,
    utl_mdp VARCHAR(100),
    utl_nom VARCHAR(100),
    utl_prenom VARCHAR(100),
    utl_pseudo VARCHAR(100), --(UNIQUE),
    utl_dtnaissance TIME,
    utl_adresse VARCHAR(100),
    utl_tel VARCHAR(20), --pattern Jerem
    utl_stylemusical VARCHAR(100),
    utl_instrument VARCHAR(100),
    utl_niveau 
)