package fr.litopia.utils;

import java.io.Console;

public class ReadingConsole {

    /**
     * Fonction qui va attendre que l'utilisateur ecrive une chaine de caracteres dans la console
     * avant de la retourner.
     * @return String la chaine de caracteres ecrit par l'utilisateur
     */
    public String readLine() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Unable to fetch console");
            System.exit(1);
        }
        return console.readLine();
    }

    /**
     * Fonction qui va attendre que l'utilisateur ecrive un entier dans la console
     * avant de le retourner.
     * @return Integer l'entier écrit par l'utilisateur
     */
    public Integer readInt() {
        Integer i = null;
        while (i == null) {
            try {
                i = Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre entier.");
            }
        }
        return i;
    }

    /**
     * Fonction qui attend que l'utilisateur ecrive un integer compris entre min et max
     * avant de le retourner.
     * @return Integer l'entier compris entre min et max
     */
    public Integer readInt(Integer min, Integer max) {
        Integer i = null;
        while (i == null || i < min || i > max) {
            i = readInt();
            if (i < min || i > max) {
                System.out.println("Veuillez saisir un nombre entier compris entre " + min + " et " + max + ".");
            }
        }
        return i;
    }

    /**
     * Fonction qui va attendre que l'utilisateur ecrive un double dans la console
     * avant de le retourner.
     * @return Double l'entier écrit par l'utilisateur
     */
    public Double readDouble() {
        Double d = null;
        while (d == null) {
            try {
                d = Double.parseDouble(readLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre.");
            }
        }
        return d;
    }

    /**
     * Fonction qui attend que l'utilisateur ecrive un double compris entre min et max
     * avant de le retourner.
     * @return Double l'entier compris entre min et max
     */
    public Double readDouble(Double min, Double max) {
        Double d = null;
        while (d == null || d < min || d > max) {
            d = readDouble();
            if (d < min || d > max) {
                System.out.println("Veuillez saisir un nombre compris entre " + min + " et " + max + ".");
            }
        }
        return d;
    }

    /**
     * Fonction qui va attendre que l'utilisateur ecrive un boolean dans la console
     * avant de le retourner.
     * @return Boolean écrit par l'utilisateur
     */
    public Boolean readBoolean() {
        Boolean b = null;
        while (b == null) {
            String s = readLine().toLowerCase();
            if (s.equals("oui") || s.equals("o") || s.equals("true") || s.equals("vrai") || s.equals("1")) {
                b = true;
            } else if (s.equals("non") || s.equals("n") || s.equals("false") || s.equals("faux") || s.equals("0")) {
                b = false;
            } else {
                System.out.println("Veuillez saisir un booleen (oui/non).");
            }
        }
        return b;
    }

    /**
     * Fonction qui va attendre que l'utilisateur ecrive une des valeur de l'enum passer en parametre
     * avant de la retourner.
     * @param <T> l'enum
     * @return T la valeur de l'enum
     **/
    public <T extends Enum<T>> T readEnum(Class<T> enumClass) {
        T t = null;
        while (t == null) {
            String s = readLine().toLowerCase();
            for (T e : enumClass.getEnumConstants()) {
                if (e.name().toLowerCase().equals(s)) {
                    t = e;
                }
            }
            if (t == null) {
                System.out.println("Veuillez saisir une valeur de l'enum " + enumClass.getSimpleName() + ".");
            }
        }
        return t;
    }




}
