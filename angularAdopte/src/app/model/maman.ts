export class Maman {
  public get password(): string | undefined {
    return this._password;
  }
  public set password(value: string | undefined) {
    this._password = value;
  }
  public get username(): string | undefined {
    return this._username;
  }
  public set username(value: string | undefined) {
    this._username = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _username?: string,
    private _password?: string
  ) {}
}
