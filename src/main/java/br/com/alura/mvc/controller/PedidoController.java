package br.com.alura.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.model.Pedido;
import br.com.alura.mvc.repository.PedidoRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario() {
		return "/pedido/formulario";
	}

	@PostMapping("novo")
    public String novo(RequisicaoNovoPedido requisicao) {
        Pedido pedido = requisicao.toPedido();
        pedidoRepository.save(pedido);

        return "pedido/formulario";
    }	
}
