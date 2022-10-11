import { Observable } from 'rxjs';
export class Image {
  public get contenu(): Uint8Array | undefined {
    return this._contenu;
  }
  public set contenu(value: Uint8Array | undefined) {
    this._contenu = value;
  }
  public get format(): string | undefined {
    return this._format;
  }
  public set format(value: string | undefined) {
    this._format = value;
  }
  public get titre(): string | undefined {
    return this._titre;
  }
  public set titre(value: string | undefined) {
    this._titre = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _titre?: string,
    private _format?: string,
    private _contenu?: Uint8Array
  ) {}
}
