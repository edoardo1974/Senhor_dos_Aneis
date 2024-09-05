module org.example.senhor_dos_aneis {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.senhor_dos_aneis to javafx.fxml;
    exports org.example.senhor_dos_aneis;
}