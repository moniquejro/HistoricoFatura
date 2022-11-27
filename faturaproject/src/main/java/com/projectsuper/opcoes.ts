import { Component, OnInit } from '@angular/core';
import { Lancamento } from '../model/Lancamento';
import { Categoria } from '../model/Categoria';
import { LancamentoService } from '../service/lancamento.service';
import { CategoriaService } from '../service/categoria.service';


@Component({
  selector: 'app-opcoes',
  templateUrl: './opcoes.component.html',
  styleUrls: ['./opcoes.component.css']
})
export class OpcoesComponent implements OnInit {

  lancamento: Lancamento = new Lancamento()
  listaLancamentos: Lancamento[]
  titulo: string

  categoria: Categoria = new Categoria()
  listaCategorias: Categoria[]
  idCategoria: number

  constructor(
    private lancamentoService: LancamentoService,
    private categoriaService: CategoriaService
  ) { }

  ngOnInit() {
      
    this.findAllLancamentos()
    this.findAllCategorias()
  }

  findAllLancamentos(){
    this.lancamentoService.getAllLancamentos().subscribe((resp: Lancamento[]) =>{
      this.listaLancamentos = resp
      console.log("listaLancamentos"+this.listaLancamentos)
    })
  }

  findAllCategorias(){
    this.categoriaService.getAllCategorias().subscribe((resp: Categoria[]) =>{
      this.listaCategorias = resp
    })
  }

  findByIdCategoria() {
    this.categoriaService.getByIdCategoria(this.categoria.id).subscribe((resp: Categoria) => {
      this.categoria = resp;
    })
  }

}