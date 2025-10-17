import java.util.List;

public class SistemaDePedidos {
    public static void main(String[] args) throws InterruptedException {
        EventBus eventBus = new EventBus();
        Barra barra = new Barra(eventBus);
        Cocina cocina = new Cocina(eventBus);
        PanelLED panel = new PanelLED();
        SistemaDeSonido sonido = new SistemaDeSonido();
        SistemaDeHumo humo = new SistemaDeHumo();

        // Generar los suscriptores.
        eventBus.suscribir(BandaTocandoEvent.class, sonido);
        eventBus.suscribir(PedidoRealizadoEvent.class, panel);
        eventBus.suscribir(BebidaServidaEvent.class, panel);
        eventBus.suscribir(ComidaPreparadaEvent.class, panel);
        eventBus.suscribir(BandaTocandoEvent.class, panel);
        eventBus.suscribir(PedidoRealizadoEvent.class, barra);
        eventBus.suscribir(PedidoRealizadoEvent.class, cocina);
        eventBus.suscribir(BandaTocandoEvent.class, humo);

        // Generar el pedido.
        PedidoRealizadoEvent pedido = new PedidoRealizadoEvent(8, 484, List.of("Cerveza", "Hamburguesa"));
        eventBus.publicar(pedido);

        new Banda(eventBus);

    }
}
