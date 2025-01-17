import {TypeCompte} from "./TypeCompte";

export interface  Compte {

    id: number;
    proprietaire: string;
    typeCompte: TypeCompte;
    balance: number;

}