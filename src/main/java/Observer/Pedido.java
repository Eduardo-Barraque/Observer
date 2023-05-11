package Observer;

import java.util.Observable;

public class Pedido extends Observable {

    private Integer idTransacao;
    private String stats;

    public Pedido(Integer idTransacao, String stats ){
    this.idTransacao = idTransacao;
    this.stats = stats;
    }

    public void mudarStatus(String stats){
        this.stats = stats;
        setChanged();
        notifyObservers();


    }
    @Override
    public String toString() {
        return "Pedido{"+
                "idTransacao=" + idTransacao +
                ", stats=" + stats + '}';
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }
}
