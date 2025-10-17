public class Barra implements Suscriptor <PedidoRealizadoEvent>, Publicador {
    private EventBus eventBus;

    public Barra(EventBus bus) {
        this.eventBus = bus;
    }

    @Override
    public <T extends Event> void publish(T evento) {

    }

    @Override
    public void onEvent(PedidoRealizadoEvent evento) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("[Barra] Pedido recibido en Mesa " + evento.getIdMesa());

        // Para revisar si hay bebidas en el pedido.
        for (String item : evento.getItems()) {
            if (item.equalsIgnoreCase("cerveza") || item.equalsIgnoreCase("soda")) {
                Thread.sleep(500);
                System.out.println("[Barra] Preparando " + item + " para la Mesa " + evento.getIdMesa());

                Thread.sleep(2000);

                // Publicar BebidaServidaEvent
                BebidaServidaEvent bebida = new BebidaServidaEvent(evento.getIdMesa(), item);
                eventBus.publicar(bebida);
            }
        }
    }
}