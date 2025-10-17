public class SistemaDeSonido implements Suscriptor <BandaTocandoEvent> {
    @Override
    public void onEvent(BandaTocandoEvent evento) {
        System.out.println("[Sistema de Sonido] Ajustando ecualizador para: " + evento.getNombreCancion());
    }
}