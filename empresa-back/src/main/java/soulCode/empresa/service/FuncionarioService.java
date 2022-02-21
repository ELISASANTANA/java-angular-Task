package soulCode.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soulCode.empresa.model.Cargo;
import soulCode.empresa.model.Funcionario;
import soulCode.empresa.repository.FuncionarioRepository;
import soulCode.empresa.service.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {
	
	@Autowired
	private CargoService cargoServ;
	
	// injeção de dependência
	@Autowired
	private FuncionarioRepository funcionarioRepo;
	
	// retorno todos funcionarios cadastrados
	public List<Funcionario> findAllWorkers() {
		return funcionarioRepo.findAll();
	}
	
	// retornar apenas um funcionario
	public Funcionario findOneWorker(Integer id_funcionario) {
		Optional<Funcionario> funcionario = funcionarioRepo.findById(id_funcionario);
		return funcionario.orElseThrow(() -> new ObjectNotFoundException("Objeto não cadastro! O id procurado: " + id_funcionario + "nao existe no db"));
	}
	
	// adicionar um funcionario
	public Funcionario addWorker(Integer id_cargo, Funcionario funcionario) {
		funcionario.setId_funcionario(null);
		Cargo cargo = cargoServ.findOneJob(id_cargo);
		funcionario.setCargo(cargo);
		return funcionarioRepo.save(funcionario);
	}
	
	// deletar um funcionario
	public void deleteWorker(Integer id_funcionario) {
		funcionarioRepo.deleteById(id_funcionario);
	}
	
	public Funcionario editWorker(Funcionario funcionario) {
		findOneWorker(funcionario.getId_funcionario());
		return funcionarioRepo.save(funcionario);
	}
	
	public List<Funcionario> fetchByCargo(Integer id_cargo) {
		List<Funcionario> funcionario = funcionarioRepo.fetchByCargo(id_cargo);
		return funcionario;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
