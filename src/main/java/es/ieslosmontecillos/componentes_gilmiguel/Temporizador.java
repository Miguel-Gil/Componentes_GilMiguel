package es.ieslosmontecillos.componentes_gilmiguel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;

public class Temporizador extends VBox {
    private int tiempoInicial;
    private int tiempoRestante;
    private Label etiquetaTiempo;
    //@FXML private Label etiquetaTiempo;
    private Timeline timeline;

    public Temporizador(int tiempoInicial) {
        /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }*/
        this.tiempoInicial = tiempoInicial;
        this.tiempoRestante = tiempoInicial;

        etiquetaTiempo = new Label(Integer.toString(tiempoRestante));
        timeline = new Timeline();

        // Configuración de la cuenta atrás
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        tiempoRestante--;
                        etiquetaTiempo.setText(Integer.toString(tiempoRestante));

                        if (tiempoRestante == 0) {
                            // Se ha alcanzado el final de la cuenta atrás
                            timeline.stop();

                            // Lanzar evento de finalización de cuenta
                            fireEvent(new ActionEvent(Temporizador.this, null));
                        }
                    }
                })
        );

        // Configuración del temporizador para ejecutarse indefinidamente
        timeline.setCycleCount(Timeline.INDEFINITE);

        getChildren().add(etiquetaTiempo);
    }

    public int getTiempoInicial() {
        return tiempoInicial;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void iniciar() {
        // Iniciar el temporizador
        timeline.playFromStart();
    }

    public void detener() {
        // Detener el temporizador
        timeline.stop();
    }

    public void setOnFinished(EventHandler<Event> handler) {
        addEventHandler(EventType.ROOT, handler);
    }
}
