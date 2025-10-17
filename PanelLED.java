public class PanelLED implements Suscriptor {
    @Override
    public void onEvent(Object evento) {
        if (evento instanceof PedidoRealizadoEvent pedido) {
            System.out.println("[PANEL LED] Pedido " + pedido.getIdPedido() + " en mesa " + pedido.getIdMesa() + ": " + pedido.getItems() + ".");
        } else if (evento instanceof BebidaServidaEvent bebida) {
            System.out.println("[PANEL LED] " + bebida.getBebida() + " servida en mesa " + bebida.getIdMesa() + ".");
        } else if (evento instanceof ComidaPreparadaEvent cocina) {
            System.out.println("[PANEL LED] " + cocina.getPlato() + " lista para pedido " + cocina.getIdPedido() + ".");
        } else if (evento instanceof BandaTocandoEvent banda) {
            System.out.println("[PANEL LED] " + banda.getNombreBanda() + " tocando: " + banda.getNombreCancion() + ".");
        }
    }
}