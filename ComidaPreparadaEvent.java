public class ComidaPreparadaEvent implements Event {
    private int idPedido;
    private String plato;

    public ComidaPreparadaEvent(int idPedido, String plato) {
        this.idPedido = idPedido;
        this.plato = plato;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getPlato() {
        return plato;
    }
}
