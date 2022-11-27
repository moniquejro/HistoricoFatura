import {Categoria} from './Categoria';

export class Lancamento {
    private id: number;
    private categoria: Categoria[];
    private data: VarDate;
    private valor: DoubleRange;
}