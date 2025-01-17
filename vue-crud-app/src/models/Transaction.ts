import {TypeTransaction} from "./TypeTransaction";

export interface  Transaction {

    id: number;
    typeTransaction: TypeTransaction;
    montant: number;
    dateTransaction: number;

}