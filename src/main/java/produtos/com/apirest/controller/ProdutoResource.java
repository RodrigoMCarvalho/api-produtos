package produtos.com.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import produtos.com.apirest.error.ResourceNotFoundException;
import produtos.com.apirest.models.Produto;
import produtos.com.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository repo;
	
	@GetMapping("/produtos")
	public ResponseEntity<?> listProdutos(){
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<?> listProdutoPorId(@PathVariable(value="id") long id){
		verificaSeProdutoExiste(id);
		return new ResponseEntity<>(repo.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/produto")
	public ResponseEntity<?> salvar(@RequestBody Produto produto) {
		return new ResponseEntity<>(repo.save(produto), HttpStatus.OK);
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> remover(@PathVariable(value="id") long id) {
		verificaSeProdutoExiste(id);
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/produto")
	public ResponseEntity<?> editar(@RequestBody Produto produto){
		verificaSeProdutoExiste(produto.getId());
		return new ResponseEntity<>(repo.save(produto), HttpStatus.OK);
	}
	
	public void verificaSeProdutoExiste(long id) {
		Produto produto = repo.findById(id);
		if(produto == null) {
			throw new ResourceNotFoundException("Não foi encontrado um produto para o ID: " + id);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
