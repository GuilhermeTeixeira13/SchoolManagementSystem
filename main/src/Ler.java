

import java.io.*;

public class Ler implements Serializable{
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
    public static int umInt() {
        while (true) {
            try {
                return Integer.parseInt(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.print("OPCÃO INVÁLIDA! DIGITE ALGO VÁLIDO --> ");
            }
        }
    }
    public static byte umByte() {
        while (true) {
            try {
                return Byte.parseByte(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.print("OPCÃO INVÁLIDA! DIGITE ALGO VÁLIDO --> ");
            }
        }
    }
    public static short umShort() {
        while (true) {
            try {
                return Short.parseShort(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.print("OPCÃO INVÁLIDA! DIGITE ALGO VÁLIDO --> ");
            }
        }
    }
    public static long umLong() {
        while (true) {
            try {
                return Long.parseLong(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.print("OPCÃO INVÁLIDA! DIGITE ALGO VÁLIDO --> ");
            }
        }
    }
    public static float umFloat() {
        while (true) {
            try {
                return Float.parseFloat(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.print("OPCÃO INVÁLIDA! DIGITE ALGO VÁLIDO --> ");
            }
        }
    }
}
