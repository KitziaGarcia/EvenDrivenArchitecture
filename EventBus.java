import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    private Map<Class<? extends Event>, List<Suscriptor<? extends Event>>> suscriptores = new HashMap<>();

    public <T extends Event> void suscribir(Class<T> tipoDeEvento, Suscriptor<T> suscriptor) {
        suscriptores.computeIfAbsent(tipoDeEvento, listaSuscriptores -> new ArrayList<>()).add(suscriptor);
    }

    public <T extends Event> void desuscribir(Class<T> tipoDeEvento, Suscriptor<T> suscriptor) {
        List<Suscriptor<? extends Event>> lista = suscriptores.get(tipoDeEvento);

        if (lista != null) {
            lista.remove(suscriptor);
        }
    }

    public <T extends Event> void publicar(T evento) throws InterruptedException {
        List<Suscriptor<? extends Event>> lista = suscriptores.get(evento.getClass());

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