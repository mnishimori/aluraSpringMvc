package br.com.alura.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Fire TV Stick 4k");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/G/32/apparel/rcxgs/tile._CB483369971_.gif");
		pedido.setUrlProduto("https://www.amazon.com.br/Fire-TV-Stick-4K-Streaming/dp/B0872Y93TY?ref=dlx_deals_gd_dcl_img_1_b92ea1f3_dt_sl15_43");
		pedido.setDescricao("Fire TV Stick 4K com Controle Remoto por Voz com Alexa (inclui comandos de TV) | Dolby Vision");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}

}
