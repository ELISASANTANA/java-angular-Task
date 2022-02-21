package soulCode.empresa.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import soulCode.empresa.model.Cargo;
import soulCode.empresa.model.Funcionario;
import soulCode.empresa.repository.FuncionarioRepository;
import soulCode.empresa.service.FuncionarioService;

@CrossOrigin
@RestController
@RequestMapping("empresa")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepo;
	
	@Autowired
	private FuncionarioService funcionarioServ;
	
	@GetMapping("/funcionario")
	public List<Funcionario> findAllWorkers() {
		List<Funcionario> funcionario = funcionarioServ.findAllWorkers();
		return funcionario;
	}
	
	@GetMapping("/funcionario/{id_funcionario}")
	public ResponseEntity<?> findOneWorker(@PathVariable Integer id_funcionario) {
		Funcionario funcionario = funcionarioServ.findOneWorker(id_funcionario);
		return ResponseEntity.ok().body(funcionario);
	}
	
	@GetMapping("/funcionario/busca-cargo/{id_cargo}")
	public List<Funcionario> fetchByCargo(@PathVariable Integer id_cargo) {
		List<Funcionario> funcionario = funcionarioServ.fetchByCargo(id_cargo);
		return funcionario;
	}	
	
	@PostMapping("/funcionario")
	public ResponseEntity<Funcionario> addJob(@RequestParam(value="cargo")Integer id_cargo, @RequestBody Funcionario funcionario) {
		funcionario = funcionarioServ.addWorker(id_cargo, funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/funcionario/{id}")
											 .buildAndExpand(funcionario.getId_funcionario())
											 .toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/funcionario/{id_funcionario}")
	public ResponseEntity<Void> deleteWorker(@PathVariable Integer id_funcionario) {
		funcionarioServ.deleteWorker(id_funcionario);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/funcionario/{id_funcionario}")
	public ResponseEntity<Void> editWorker(@RequestParam(value="cargo")Cargo cargo, @PathVariable Integer id_funcionario, @RequestBody Funcionario funcionario) {
		funcionario.setId_funcionario(id_funcionario);
		funcionario.setCargo(cargo);
		funcionario = funcionarioServ.editWorker(funcionario);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
