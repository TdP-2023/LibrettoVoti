module it.polito.tdp.libretto {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens it.polito.tdp.libretto to javafx.fxml;
    exports it.polito.tdp.libretto;
}
