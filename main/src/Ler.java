import java.io.*;

public class Ler {
// Método para ler uma String:

    public static String umaString() {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            s = in.readLine();
        } catch (IOException e) {
            System.out.println("Erro ao ler fluxo de entrada.");
        }
        return s;
    }
// Método para ler um int:

    public static int umInt() {
        while (true) {
            try {
                return Integer.parseInt(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Não é um inteiro válido!!!");
            }
        }
    }

// Método para ler um byte:
    public static byte umByte() {
        while (true) {
            try {
                return Byte.parseByte(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Não é um byte válido!!!");
            }
        }
    }
// Método para ler um short:

    public static short umShort() {
        while (true) {
            try {
                return Short.parseShort(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Não é um short válido!!!");
            }
        }
    }
// Método para ler um long:

    public static long umLong() {
        while (true) {
            try {
                return Long.parseLong(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Não é um long válido!!!");
            }
        }
    }
//// Método para ler um float;

    public static float umFloat() {
        while (true) {
            try {
                return Float.parseFloat(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Não é um float válido!!!");
            }
        }
    }
}
