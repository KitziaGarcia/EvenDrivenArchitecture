public class SistemaDeHumo implements Suscriptor <BandaTocandoEvent> {
    @Override
    public void onEvent(BandaTocandoEvent evento) {
        if (evento.getNombreCancion().equals("Through The Fire And The Flames")) {
            System.out.println("[Sistema de Humo Activado]");
        }
    }
}