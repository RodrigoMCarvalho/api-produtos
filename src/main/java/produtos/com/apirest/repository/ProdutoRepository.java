package produtos.com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import produtos.com.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);

}
