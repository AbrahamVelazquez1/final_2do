package examen;

public class Convertidor {
    public static String arabigoARomano(int numero) {
        if (numero < 1 || numero > 50) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 50.");
        }

        StringBuilder resultado = new StringBuilder();
        while (numero >= 50) { resultado.append("L"); numero -= 50; }
        while (numero >= 40) { resultado.append("XL"); numero -= 40; }
        while (numero >= 10) { resultado.append("X"); numero -= 10; }
        while (numero >= 9)  { resultado.append("IX"); numero -= 9; }
        while (numero >= 5)  { resultado.append("V"); numero -= 5; }
        while (numero >= 4)  { resultado.append("IV"); numero -= 4; }
        while (numero >= 1)  { resultado.append("I"); numero -= 1; }

        return resultado.toString();
    }

    public static int romanoAArabigo(String romano) {
        if (!esRomanoValido(romano)) {
            throw new IllegalArgumentException("Número romano inválido.");
        }

        int resultado = 0;
        int valorAnterior = 0;

        for (char c : romano.toCharArray()) {
            int valorActual = valorRomano(c);
            if (valorActual > valorAnterior) {
                resultado += valorActual - 2 * valorAnterior;
            } else {
                resultado += valorActual;
            }
            valorAnterior = valorActual;
        }
        return resultado;
    }

    public static boolean esRomanoValido(String romano) {
        // Validar que el número romano esté entre I y L
        return romano.matches("^(L|XL|X{0,3}(IX|IV|V?I{0,3}))$");
    }

    private static int valorRomano(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            default: throw new IllegalArgumentException("Carácter romano inválido.");
        }
    }
}