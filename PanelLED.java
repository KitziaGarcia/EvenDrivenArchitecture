public class PanelLED implements Suscriptor {
    private EventBus eventBus;

    public PanelLED(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void onEvent(Object evento) {
        if (evento instanceof PedidoRealizadoEvent pedido) {
            System.out.println("[PANEL LED] Pedido " + pedido.getIdPedido() + " en mesa " + pedido.getIdMesa() + ": " + pedido.getItems() + ".");
        } else if (evento instanceof BebidaServidaEvent bebida) {
            System.out.println("[PANEL LED] Nueva bebida servida en mesa " + bebida.getIdMesa() + ".");
        } else if (evento instanceof ComidaPreparadaEvent cocina) {
            System.out.println("[PANEL LED] Comida lista de pedido " + cocina.getIdPedido() + ".");
        } else if (evento instanceof BandaTocandoEvent banda) {
            System.out.println("[PANEL LED] Banda tocando: " + banda.getNombreCancion() + ".");
        }
    }
}