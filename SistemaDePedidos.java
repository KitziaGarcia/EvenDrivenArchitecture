import java.util.List;

public class SistemaDePedidos {
    public static void main(String[] args) throws InterruptedException {
        EventBus eventBus = new EventBus();
        Barra barra = new Barra(eventBus);
        Cocina cocina = new Cocina(eventBus);
        PanelLED panel = new PanelLED(eventBus);
        SistemaDeSonido sonido = new SistemaDeSonido(eventBus);

        eventBus.suscribir(PedidoRealizadoEvent.class, panel);
        eventBus.suscribir(BebidaServidaEvent.class, panel);
        eventBus.suscribir(ComidaPreparadaEvent.class, panel);
        eventBus.suscribir(BandaTocandoEvent.class, panel);
        eventBus.suscribir(PedidoRealizadoEvent.class, barra);
        eventBus.suscribir(PedidoRealizadoEvent.class, cocina);
        eventBus.suscribir(BandaTocandoEvent.class, sonido);

        PedidoRealizadoEvent pedido = new PedidoRealizadoEvent(5, 123, List.of("cerveza", "hamburguesa"));
        eventBus.publicar(pedido);


    }
}
