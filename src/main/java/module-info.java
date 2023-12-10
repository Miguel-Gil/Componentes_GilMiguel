module es.ieslosmontecillos.componentes_gilmiguel {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.componentes_gilmiguel to javafx.fxml;
    exports es.ieslosmontecillos.componentes_gilmiguel;
}