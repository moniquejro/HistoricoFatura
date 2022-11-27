import { Injectable } from @angular;
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Produto } from '../model/Produto';

@Injectable({
  providedIn: 'root'
})
export class LancamentoService {

  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization', localStorage.getItem('token'))
  }

  getAllLancamentos(){
    return this.http.get('http://localhost:5500/lancamento', this.token)
  }

  getByIdLancamentos(id: number) {
    return this.http.get(`http://localhost:5500/produtos/${id}`, this.token)
  }

}