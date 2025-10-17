import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus implements EventBusI {
    private Map<Class<? extends Event>, List<Suscriptor<? extends Event>>> suscriptores = new HashMap<>();

    public <T extends Event> void suscribir(Class<T> tipoDeEvento, Suscriptor<T> suscriptor) {
        // Agregar los eventos y sus respectivos suscriptores en una lista.
        suscriptores.computeIfAbsent(tipoDeEvento, listaSuscriptores -> new ArrayList<>()).add(suscriptor);
    }

    public <T extends Event> void desuscribir(Class<T> tipoDeEvento, Suscriptor<T> suscriptor) {
        // Obtener la lista de suscriptores de un evento.
        List<Suscriptor<? extends Event>> lista = suscriptores.get(tipoDeEvento);

        // Eliminar el suscriptor deseado.
        if (lista != null) {
            lista.remove(suscriptor);
        }
    }

    public <T extends Event> void publicar(T evento) {
        // Obtener la lista de suscriptores de un evento.
        List<Suscriptor<? extends Event>> lista = suscriptores.get(evento.getClass());

        // Llevar a cabo el evento de cada suscriptor.
        if (lista != null) {
            for (Suscriptor sub : lista) {
                Suscriptor<T> s = sub;
                new Thread(() -> {
                    try {
                        s.onEvent(evento);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        }
    }
}