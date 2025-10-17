public interface EventBusI {
    <T extends Event> void suscribir(Class<T> tipo, Suscriptor<T> suscriptor);
    <T extends Event> void desuscribir(Class<T> tipo, Suscriptor<T> suscriptor);
    <T extends Event> void publicar(T evento);
}