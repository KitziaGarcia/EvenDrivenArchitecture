public class SistemaDeSonido implements Suscriptor <BandaTocandoEvent> {
    private EventBus eventBus;

    public SistemaDeSonido(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void onEvent(BandaTocandoEvent evento) {

    }
}