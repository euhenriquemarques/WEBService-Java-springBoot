package euhenriquemarques.WebService.WebService.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import euhenriquemarques.WebService.WebService.Respository.CadastroEnderecoRepository;
import euhenriquemarques.WebService.WebService.modelo.CadastroEndereco;

@RestController
@RequestMapping("/cadastro")
public class CadastroEnderecoController {
	
	@Autowired
	CadastroEnderecoRepository cer;
	
	
	@GetMapping(produces ="application/json")
	public @ResponseBody Iterable<CadastroEndereco> listarCadastro(){
		
		Iterable<CadastroEndereco> cadastro = cer.findAll();
		
		return cadastro;
	}
	
	@PostMapping
	public CadastroEndereco CadastroEndereco(@RequestBody @Valid CadastroEndereco cadastro) {
		return cer.save(cadastro);
		
	}
	
	@DeleteMapping
	public CadastroEndereco DeletarEndereco(@RequestBody @Valid CadastroEndereco cadastro) {
		cer.delete(cadastro);
		
		return cadastro;
	}
	
	

}
