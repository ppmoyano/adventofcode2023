package src.day2;

import src.util.Util;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Day2CubeCoundrum {
    public static void main(String[] args) {
        List<String> input = Util.getInput("src/day2/day2input.txt");
        int totalSegundo = 0;
        int totalPrimero = 0;
        for (String linea : input) {
            List<String> indiceAndGames = List.of(linea.split(":"));
            int indice = Integer.parseInt(List.of(indiceAndGames.get(0).split(" ")).get(1));
            boolean pass = true;
            String[] games = indiceAndGames.get(1).split(";");
            //aqui es cada linea
            int minimunRed = 1;
            int minimunGreen = 1;
            int minimunBlue = 1;
            for (String game : games) {

                boolean fR = true;
                boolean fG = true;
                boolean fB = true;
                String[] subsets = game.split(",");
                //aqui es cada juego dentro de cada linea
                for (String groupOfColor : subsets) {
                    List<String> result = List.of(groupOfColor.split(" "));
                    if (result.get(2).equals("red")) {
                        if (Integer.parseInt(result.get(1)) > minimunRed) {
                            minimunRed = Integer.parseInt(result.get(1));
                        }
                        if (Integer.parseInt(result.get(1)) > 12) {
                            pass = false;
                        }

                    }
                    if (result.get(2).equals("green")) {
                        if (Integer.parseInt(result.get(1)) > minimunGreen) {
                            minimunGreen = Integer.parseInt(result.get(1));
                        }
                        if (Integer.parseInt(result.get(1)) > 13) {
                            pass = false;
                        }
                    }
                    if (result.get(2).equals("blue")) {
                        if (Integer.parseInt(result.get(1)) > minimunBlue) {
                            minimunBlue = Integer.parseInt(result.get(1));
                        }
                        if (Integer.parseInt(result.get(1)) > 14) {
                            pass = false;
                        }
                    }

                }
            }
            if (pass) {
                totalPrimero = totalPrimero + indice;
            }
            totalSegundo = totalSegundo + (minimunBlue * minimunRed * minimunGreen);
        }
        System.out.println("Resultado primer Ejercicio: " + totalPrimero);
        System.out.println("Resultado Segundo Ejercicio: " + totalSegundo);
    }

}


