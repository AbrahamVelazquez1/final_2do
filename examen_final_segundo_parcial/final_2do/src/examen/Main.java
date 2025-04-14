package examen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            String[] opciones = {"Arábigo a Romano", "Romano a Arábigo", "Salir"};
            int eleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Conversor de Números",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (eleccion == 2 || eleccion == JOptionPane.CLOSED_OPTION) {
                break;
            }

            try {
                if (eleccion == 0) {
                    String entrada = JOptionPane.showInputDialog("Ingrese un nUmero arábigo (1-50):");
                    int numero = Integer.parseInt(entrada);
                    if (numero < 1 || numero > 50) {
                        JOptionPane.showMessageDialog(null, "El número debe estar entre 1 y 50.");
                        continue;
                    }
                    String romano = Convertidor.arabigoARomano(numero);
                    JOptionPane.showMessageDialog(null, "El número romano es: " + romano);
                } else if (eleccion == 1) {
                    String romano = JOptionPane.showInputDialog("Ingrese un número romano válido (I-L):");
                    if (!Convertidor.esRomanoValido(romano)) {
                        JOptionPane.showMessageDialog(null, "Número romano inválido.");
                        continue;
                    }
                    int arabigo = Convertidor.romanoAArabigo(romano);
                    JOptionPane.showMessageDialog(null, "El número arábigo es: " + arabigo);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número válido.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}