module app.project_apartment_how_much {


    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
//    requires mysql.connector.java;


    opens com.folaSmile.apartSearch to javafx.fxml;
    opens com.folaSmile.apartSearch.databaseClass.tableModel to javafx.fxml;
    opens com.folaSmile.apartSearch.databaseClass.databaseTest to javafx.fxml;
    opens com.folaSmile.apartSearch.databaseClass.testConnection2 to javafx.fxml;
    opens com.folaSmile.apartSearch.databaseClass.userModel to javafx.fxml;

    exports com.folaSmile.apartSearch;
    exports com.folaSmile.apartSearch.databaseClass.tableModel;
    exports com.folaSmile.apartSearch.databaseClass.databaseTest;
    exports com.folaSmile.apartSearch.databaseClass.testConnection2;
    exports com.folaSmile.apartSearch.databaseClass.userModel;


}