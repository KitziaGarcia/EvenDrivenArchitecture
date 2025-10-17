public interface Suscriptor <T> {
    public void onEvent(T evento) throws InterruptedException;
}
