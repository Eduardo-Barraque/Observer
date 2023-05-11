package Observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    void deveNotificarCliente() {
        Pedido pedido1 = new Pedido(1, "Pedido Criado");
        Cliente cliente1 = new Cliente("Cliente 1");
        cliente1.acompanhar(pedido1);
        pedido1.mudarStatus("Saiu para expedição");
        assertEquals("Cliente 1, status atualizado no Pedido{idTransacao=1, stats=Saiu para expedição}", cliente1.getUltimoStatus());
    }

    @Test
    void naoDeveNotificarCliente(){
        Pedido pedido1 = new Pedido(1, "Pedido Criado");
        Cliente cliente1 = new Cliente("Cliente 1");
        pedido1.mudarStatus("Saiu para expedição");
        assertEquals(null, cliente1.getUltimoStatus());
    }

    @Test
    void deveNotificarCliente1() {
        Pedido pedido1 = new Pedido(1, "Pedido Criado");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(pedido1);
        pedido1.mudarStatus("Em Transito");
        assertEquals("Cliente 1, status atualizado no Pedido{idTransacao=1, stats=Em Transito}", cliente1.getUltimoStatus());
    }
    @Test
    void deveNotificarClientes() {
        Pedido pedido1 = new Pedido(1, "Pedido Criado");
        Pedido pedido2 = new Pedido(2, "Pedido Criado");

        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(pedido1);
        cliente2.acompanhar(pedido2);
        pedido1.mudarStatus("Entregue");
        pedido2.mudarStatus("Em rota");
        assertEquals("Cliente 1, status atualizado no Pedido{idTransacao=1, stats=Entregue}", cliente1.getUltimoStatus());
        assertEquals("Cliente 2, status atualizado no Pedido{idTransacao=2, stats=Em rota}", cliente2.getUltimoStatus());
    }

}
