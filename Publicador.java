public interface Publicador {
    <T extends Event> void publicar(T evento) throws InterruptedException;
}