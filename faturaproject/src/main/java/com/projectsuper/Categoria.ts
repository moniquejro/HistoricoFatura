import {Lancamento} from './Lancamento';

export class Categoria {
    private id: number;
    private lancamento: Lancamento[];
    private data: VarDate;
    private valor: DoubleRange;
}