package br.com.alura.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;

import br.com.alura.mvc.model.Pedido;
import br.com.alura.mvc.repository.PedidoRepository;

@SpringBootApplication
public class MudiApplication {
	
	private final PedidoRepository pedidoRepository;
	

	public MudiApplication(PedidoRepository pedidoRepository) {
		super();
		this.pedidoRepository = pedidoRepository;
		
		this.popularPedidos();
	}


	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
	}


	private void popularPedidos() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Fire TV Stick 4k");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/G/32/apparel/rcxgs/tile._CB483369971_.gif");
		pedido.setUrlProduto("https://www.amazon.com.br/Fire-TV-Stick-4K-Streaming/dp/B0872Y93TY?ref=dlx_deals_gd_dcl_img_1_b92ea1f3_dt_sl15_43");
		pedido.setDescricao("Fire TV Stick 4K com Controle Remoto por Voz com Alexa (inclui comandos de TV) | Dolby Vision");
		
		if (!this.pedidoRepository.findOne(Example.of(pedido)).isPresent()) {
			pedidoRepository.save(pedido);
		}
	}

}
