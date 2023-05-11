package Observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimoStatus;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimoStatus() {
        return this.ultimoStatus;
    }

    public void acompanhar(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable pedido, Object arg1) {
        this.ultimoStatus = this.nome + ", status atualizado no " + pedido.toString();
    }
}
