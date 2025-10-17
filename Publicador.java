public interface Publicador {
    <T extends Event> void publish(T evento);
}