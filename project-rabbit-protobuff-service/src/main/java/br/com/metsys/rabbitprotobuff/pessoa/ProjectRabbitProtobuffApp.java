package br.com.metsys.rabbitprotobuff.pessoa;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.metsys.rabbitprotobuff")
public class ProjectRabbitProtobuffApp extends Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectRabbitProtobuffApp.class, args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
