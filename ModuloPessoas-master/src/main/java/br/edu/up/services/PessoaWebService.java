package br.edu.up.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import br.edu.up.pessoa.model.Pessoa;
import br.edu.up.pessoa.repository.PessoaRepository;

@Service
@RestController
@RequestMapping("/pessoas")
public class PessoaWebService {
	
	@Autowired
	PessoaRepository pr;
	
	
	@PostMapping
	@RequestMapping(value = "/cadastrarPessoa", method = RequestMethod.POST)
	public void persistirProduto(@RequestBody Pessoa produto) {
		pr.save(produto);
		System.out.println("Produto cadastrado com sucesso!");
	}
	
	@GetMapping
	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    public List<Pessoa> listaPessoa(@PathVariable("primeiroNome") String nome, Model model) {
          List<Pessoa> listaProdutos = pr.findByPrimeiroNome(nome);
          if (listaProdutos != null) {
                model.addAttribute("produtos", listaProdutos);
          }
          return listaProdutos;
    }
}
