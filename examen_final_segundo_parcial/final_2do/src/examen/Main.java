package examen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] opciones = {"Arabigo a Romano", "Romano a Arabigo", "Salir"};

        while (true) {
            int eleccion = JOptionPane.showOptionDialog(
                null,
                "Elige una opcion:",
                "Conversor de Numeros",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (eleccion == 2 || eleccion == JOptionPane.CLOSED_OPTION) break;

            try {
                if (eleccion == 0) {
                    String entrada = JOptionPane.showInputDialog("Escribe un numero arabigo entre 1 y 50:");
                    int numero = Integer.parseInt(entrada);

                    if (numero < 1 || numero > 50) {
                        JOptionPane.showMessageDialog(null, "El numero debe estar entre 1 y 50.");
                        continue;
                    }

                    String romano = Convertidor.arabigoARomano(numero);
                    JOptionPane.showMessageDialog(null, "Equivalente en romano: " + romano);

                } else if (eleccion == 1) {
                    String romano = JOptionPane.showInputDialog("Escribe un numero romano valido (I a L):");

                    if (!Convertidor.esRomanoValido(romano)) {
                        JOptionPane.showMessageDialog(null, "Numero romano no valido.");
                        continue;
                    }

                    int arabigo = Convertidor.romanoAArabigo(romano);
                    JOptionPane.showMessageDialog(null, "Equivalente en arabigo: " + arabigo);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no valida. Ingresa un numero correcto.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
