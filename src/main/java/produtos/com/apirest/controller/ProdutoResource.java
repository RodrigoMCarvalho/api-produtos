package produtos.com.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import produtos.com.apirest.models.Produto;
import produtos.com.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository repo;
	
	@GetMapping("/produtos")
	public List<Produto> listProdutos(){
		return repo.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto listProdutoPorId(@PathVariable(value="id") long id){
		return repo.findById(id);
	}
	
	@PostMapping("/produto")
	public Produto save (@RequestBody Produto produto) {
		return repo.save(produto);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
