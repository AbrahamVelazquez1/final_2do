package examen;

public class Convertidor {

    public static String arabigoARomano(int numero) {
        if (numero < 1 || numero > 50) {
            throw new IllegalArgumentException("El numero debe estar entre 1 y 50.");
        }

        StringBuilder resultado = new StringBuilder();
        int[] valores = {50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                resultado.append(simbolos[i]);
                numero -= valores[i];
            }
        }

        return resultado.toString();
    }

    public static int romanoAArabigo(String romano) {
        if (!esRomanoValido(romano)) {
            throw new IllegalArgumentException("Numero romano no valido.");
        }

        int resultado = 0;
        int valorAnterior = 0;

        for (char c : romano.toCharArray()) {
            int valorActual = valorRomano(c);
            resultado += valorActual > valorAnterior
                ? valorActual - 2 * valorAnterior
                : valorActual;
            valorAnterior = valorActual;
        }

        return resultado;
    }

    public static boolean esRomanoValido(String romano) {
        return romano.matches("^(L|XL|X{0,3}(IX|IV|V?I{0,3}))$");
    }

    private static int valorRomano(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            default -> throw new IllegalArgumentException("Caracter romano incorrecto.");
        };
    }
}
