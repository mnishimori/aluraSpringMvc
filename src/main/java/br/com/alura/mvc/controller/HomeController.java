package br.com.alura.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.model.Pedido;
import br.com.alura.mvc.repository.PedidoRepository;

@Controller
@RequestMapping("/principal")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public ModelAndView home(Model model) {
		
		List<Pedido> pedidos = pedidoRepository.findAll();
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		
		return mv;
	}

	@GetMapping()
	public List<Pedido> lista() {
		
		List<Pedido> pedidos = pedidoRepository.findAll();
		
		return pedidos;
	}
}
