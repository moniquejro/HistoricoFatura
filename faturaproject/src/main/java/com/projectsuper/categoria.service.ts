import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Categoria } from '../model/Categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization', localStorage.getItem('token'))
  }

  getAllCategorias(){
    return this.http.get('http://localhost:9000/categoria', this.token)
  }

  getByIdCategoria(id: number) {
    return this.http.get(`http://localhost:9000/categoria/${id}`, this.token)
  }
/*
metodos que seriam utilizados caso fossemos incluir ações como transferencia, saque, débito no cartão e etc
  postCategoria(categoria: Categoria) {
    return this.http.post('http://localhost:9000/categoria', categoria, this.token)
  }

  putCategoria(categoria: Categoria) {
    return this.http.put('http://localhost:9000/categoria', categoria, this.token)
  }

  deleteByIdCategoria(id: number){
    return this.http.delete(`http://localhost:9000/categoria/${id}`, this.token)
  }
*/
  getByNomeCategoria(nome: string){
    return this.http.get(`http://localhost:9000/categoria/nome/${nome}`, this.token)
  }

}