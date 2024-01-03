package br.com.pedidos.foxpedidos.repository.Cliente;

import br.com.pedidos.foxpedidos.dto.Cliente.DTOListarCliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedidos.foxpedidos.domain.Cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Page<Cliente> findByAtivoTrue(Pageable paginacao);
}
