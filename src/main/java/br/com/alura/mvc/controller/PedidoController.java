package br.com.alura.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.model.Pedido;
import br.com.alura.mvc.model.User;
import br.com.alura.mvc.repository.PedidoRepository;
import br.com.alura.mvc.repository.UserRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "/pedido/formulario";
	}

	@PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "/pedido/formulario";
		}
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User user = userRepository.findByUsername(name);
		
        Pedido pedido = requisicao.toPedido();
        pedido.setUser(user);
        pedidoRepository.save(pedido);

        return "pedido/formulario";
    }	
}
