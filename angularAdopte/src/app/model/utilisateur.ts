export class Utilisateur {
  public get dateNaissance(): string | undefined {
    return this._dateNaissance;
  }
  public set dateNaissance(value: string| undefined )  {
    this._dateNaissance = value;
  }
  public get adresse(): string | undefined {
    return this._adresse;
  }
  public set adresse(value: string| undefined ) {
    this._adresse = value;
  }
  public get niveau(): string| undefined  {
    return this._niveau;
  }
  public set niveau(value: string| undefined ) {
    this._niveau = value;
  }
  public get telephone(): number | undefined {
    return this._telephone;
  }
  public set telephone(value: number| undefined ) {
    this._telephone = value;
  }
  public get mail(): string | undefined {
    return this._mail;
  }
  public set mail(value: string| undefined ) {
    this._mail = value;
  }
  public get prenom(): string | undefined {
    return this._prenom;
  }
  public set prenom(value: string| undefined ) {
    this._prenom = value;
  }
  public get nom(): string| undefined  {
    return this._nom;
  }
  public set nom(value: string| undefined ) {
    this._nom = value;
  }
  public get id(): number| undefined  {
    return this._id;
  }
  public set id(value: number| undefined ) {
    this._id = value;
  }




  constructor(
    private _id?: number,
    private _nom?: string,
    private _prenom?: string,
    private _mail?: string,
    private _telephone?: number,
    private _niveau?: string,
    private _adresse?: string,
    private _dateNaissance?: string,
  ) {}
}
