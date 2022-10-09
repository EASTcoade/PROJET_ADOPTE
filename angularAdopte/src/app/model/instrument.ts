import { Image } from './image';
export class Instrument {
  public get image(): Image | undefined {
    return this._image;
  }
  public set image(value: Image | undefined) {
    this._image = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _nom?: string,
    private _image?: Image
  ) {}
}
