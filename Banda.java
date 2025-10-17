import java.util.List;

public class Banda implements Publicador {
    EventBus eventBus;

    public Banda(EventBus eventBus) throws InterruptedException {
        this.eventBus = eventBus;
        tocarCancion();
    }

    public void tocarCancion() throws InterruptedException {
        List<String> canciones = List.of("She's In The Rain", "Through The Fire And The Flames");

        for (String cancion : canciones) {
            Thread.sleep(3500);
            publicar(new BandaTocandoEvent("The Rose", cancion, 180));
        }
    }

    @Override
    public <T extends Event> void publicar(T evento) {
        eventBus.publicar(evento);
    }
}