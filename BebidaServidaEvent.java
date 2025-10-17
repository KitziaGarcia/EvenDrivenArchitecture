public class BebidaServidaEvent implements Event {
    private int idMesa;
    private String bebida;

    public BebidaServidaEvent(int idMesa, String bebida) {
        this.idMesa = idMesa;
        this.bebida = bebida;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public String getBebida() {
        return bebida;
    }
}
