import { Funcionario } from './../models/funcionarioModel';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  baseUrl: string = 'http://localhost:8080/empresa'

  constructor(private http: HttpClient) { }

  findAllWorkers(): Observable<Funcionario[]> {
    const url = `${this.baseUrl}/funcionario`
    return this.http.get<Funcionario[]>(url)
  }

  listWorkerJob(id_cargo: string): Observable<Funcionario[]> {
    const url = `${this.baseUrl}/funcionario/busca-cargo/${id_cargo}`
    return this.http.get<Funcionario[]>(url)
  }

  addWorker(funcionario: Funcionario, id_cargo: string): Observable<Funcionario> {
    const url = `${this.baseUrl}/funcionario?cargo=${id_cargo}`
    return this.http.post<Funcionario>(url, funcionario)
  }

  oneWorker(id_funcionario: string): Observable<Funcionario> {
    const url = `${this.baseUrl}/funcionario/${id_funcionario}`
    return this.http.get<Funcionario>(url)
  }

  deleteWorker(id_funcionario: string, id_cargo: string): Observable<void> {
    const url = `${this.baseUrl}/funcionario/${id_funcionario}`
    return this.http.delete<void>(url)
  }

  editWorker() {

  }

}
