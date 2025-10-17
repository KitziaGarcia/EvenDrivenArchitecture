public class Cocina implements Suscriptor <PedidoRealizadoEvent>, Publicador {
    private EventBus eventBus;

    public Cocina(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public <T extends Event> void publish(T evento) {

    }

    @Override
    public void onEvent(PedidoRealizadoEvent evento) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("[Cocina] Pedido recibido en Mesa " + evento.getIdMesa());

        // Para revisar si hay comida en el pedido.
        for (String item : evento.getItems()) {
            if (item.equalsIgnoreCase("hamburguesa") || item.equalsIgnoreCase("orden de pollo")) {
                Thread.sleep(500);
                System.out.println("[Cocina] Preparando " + item + " para la Mesa " + evento.getIdMesa());

                Thread.sleep(5000);

                // Publicar ComidaPreparadaEvent
                ComidaPreparadaEvent comida = new ComidaPreparadaEvent(evento.getIdMesa(), item);
                eventBus.publicar(comida);
            }
        }
    }
}