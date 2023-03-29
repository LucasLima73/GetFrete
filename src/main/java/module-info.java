module br.com.getfrete.getfrete {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires AnimateFX;
    requires com.jfoenix;
    requires java.desktop;

    opens br.com.getfrete.getfrete to javafx.fxml;
    exports br.com.getfrete.getfrete;
    exports br.com.getfrete.getfrete.Controller;
    opens br.com.getfrete.getfrete.Controller to javafx.fxml;
}