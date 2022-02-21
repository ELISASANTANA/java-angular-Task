import { Funcionario } from './../../models/funcionarioModel';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edicao-funcionario',
  templateUrl: './edicao-funcionario.component.html',
  styleUrls: ['./edicao-funcionario.component.css']
})
export class EdicaoFuncionarioComponent implements OnInit {

  funcionario: Funcionario = {
    id_funcionario: '',
    func_nome: '',
    func_cidade: ''
  }

  constructor() { }

  ngOnInit(): void {
  }

}
