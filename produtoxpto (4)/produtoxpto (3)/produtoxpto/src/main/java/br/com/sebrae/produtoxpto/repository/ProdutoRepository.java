package br.com.sebrae.produtoxpto.repository;

import br.com.sebrae.produtoxpto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
