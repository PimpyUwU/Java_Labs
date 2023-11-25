package main;

import main.Menu.MenuRunner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    static Logger log;
    public static void main(String[] args) {
        loadLog4j();
        log = Logger.getLogger(Main.class.getName());

        log.error("Starting the application");
        MenuRunner.start(args);
        log.info("Application has started");
    }

    public static void loadLog4j(){
        String log4jConfPath = "D:\\Code\\Java\\Lab_4_pp\\Chef_lab4-8\\src\\main\\resources\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }
}