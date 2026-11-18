package br.com.sebrae.produtoxpto.controller;

import br.com.sebrae.produtoxpto.model.Produto;
import br.com.sebrae.produtoxpto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Abre a aba de Cadastro (página inicial)
    @GetMapping("/")
    public String paginaCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastro";
    }

    // Salva o produto no banco e redireciona para o Estoque
    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        if (produto.getQuantidade() == null) {
            produto.setQuantidade(1);
        }
        produtoRepository.save(produto);
        return "redirect:/estoque";
    }

    // Abre a aba de Estoque listando todos os produtos
    @GetMapping("/estoque")
    public String paginaEstoque(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "estoque";
    }

    // Exclui um produto do estoque
    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/estoque";
    }
}

