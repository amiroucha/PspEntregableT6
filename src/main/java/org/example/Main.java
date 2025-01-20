package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String linea;
        System.out.println("Introduce un nombre de fichero");
        String clienteFichero = scanner.nextLine();
        try{
            //expresion del nombre
            Pattern pat = Pattern.compile("[a-z]{2}_[a-z0-9]{2,5}(.txt|.csv)");
            Matcher mat = pat.matcher(clienteFichero);

            //Si el nombre es valido respecto a la expresion
            if (mat.matches()) {

                log.info("Nombre de fichero con formato válido: ".concat(clienteFichero));
                System.out.println("Nombre de fichero con formato válido: " + clienteFichero);
                //creo la ruta del fichero
                File fichero = new File("./".concat(clienteFichero));
                //creo el buffer para leer
                BufferedReader leer = new BufferedReader(new FileReader(fichero));

                while((linea = leer.readLine()) != null){//mientras que tenga algo que leer



                }


            } else {
                System.out.println(" no ees valida " + clienteFichero);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            log.error("Error de fichero : ".concat(e.getMessage()));
        }

    }
}