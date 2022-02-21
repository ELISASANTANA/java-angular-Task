import { Router } from '@angular/router';
import { FuncionarioService } from './../../servicos/funcionario.service';
import { Funcionario } from './../../models/funcionarioModel';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-func',
  templateUrl: './lista-func.component.html',
  styleUrls: ['./lista-func.component.css']
})
export class ListaFuncComponent implements OnInit {

  funcionarios: Funcionario[] = []

  constructor(private funcionarioService: FuncionarioService, private router: Router) { }

  ngOnInit(): void {
    this.listAllWorkers()
  }

  listAllWorkers() {
    this.funcionarioService.findAllWorkers().subscribe(res => {
      this.funcionarios = res
    })
  }

}
