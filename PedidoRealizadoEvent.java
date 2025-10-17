import java.util.List;

public class PedidoRealizadoEvent implements Event {
    private int idMesa;
    private int idPedido;
    private List<String> items;

    public PedidoRealizadoEvent(int idMesa, int idPedido, List<String> items) {
        this.idMesa = idMesa;
        this.idPedido = idPedido;
        this.items = items;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public List<String> getItems() {
        return items;
    }
}
