package br.com.alura.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mvc.model.Pedido;
import br.com.alura.mvc.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido valueOf);
	
}
