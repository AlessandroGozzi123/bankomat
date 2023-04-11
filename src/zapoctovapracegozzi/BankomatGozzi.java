/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zapoctovapracegozzi;

import java.util.InputMismatchException;
import java.util.Scanner;
import static zapoctovapracegozzi.Banka.autentikace;
import static zapoctovapracegozzi.Banka.odeslaniKlientaDoBankomatu;

/**
 *
 * @author Alessandro
 */
public class BankomatGozzi {

    static Scanner sc = new Scanner(System.in);
    final static int MAX_VYBER = 300;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean programPracuje = true;
        while (programPracuje == true) {
            Klient klient;
            vypisHlavnihoMenu();
            int volba = zadejInt();
            switch (volba) {
                case 1:
                    klient = prihlaseni();
                    if (klient != null) {
                        prihlasenyUzivatel(klient);
                    }
                    break;
                case 2:
                    programPracuje = false;
                    System.out.println("Program ukončen.");
                    break;
            }
        }
    }

    private static Klient prihlaseni() {
        long cisloUctu;
        int pin;
        Klient zakaznik = null;
        System.out.println("Zadejte prosím číslo Vašeho účtu:");
        cisloUctu = zadejLong();
        System.out.println("Zadejte prosím pin od Vašeho účtu:");
        pin = zadejInt();
        boolean udajeSouhlasi = autentikace(cisloUctu, pin);
        if (udajeSouhlasi == true) {
            zakaznik = odeslaniKlientaDoBankomatu(cisloUctu, pin);
        } else {
            System.out.println("");
            System.out.println("Uživatel nenalezen. Prosím přihlašte se znova.");
            System.out.println("");
        }
        return zakaznik;
    }

    private static int zadejKladnyInt() {
        int vysledek = 0;
        while (vysledek <= 0) {
            vysledek = zadejInt();
            if (vysledek <= 0) {
                System.out.println("");
                System.out.println("Prosím zadejte kladné číslo.");
                System.out.println("");
            }
        }
        return vysledek;
    }

    private static int zadejInt() {
        boolean bezi = true;
        int vysledek = 0;
        while (bezi) {
            try {
                vysledek = sc.nextInt();
                bezi = false;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Špatně zadaný formát! Napiště znova.");
                sc.nextLine();
            }
        }
        return vysledek;
    }

    private static long zadejLong() {
        boolean bezi = true;
        long vysledek = 0;
        while (bezi) {
            try {
                vysledek = sc.nextLong();
                bezi = false;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Špatně zadaný formát! Napiště znova.");
                sc.nextLine();
            }
        }
        return vysledek;
    }

    private static void vypisHlavnihoMenu() {
        System.out.println("Vítejte ve virtuálním bankomatu.");
        System.out.println("Menu:");
        System.out.println("1. Přihlásit se.");
        System.out.println("2. Ukončit program.");
        System.out.println("Pro volbu zadejte číslo.");
        System.out.println("");
    }

    private static void vypisMenuPrihlasenehoUzivatele() {
        System.out.println("Menu:");
        System.out.println("1. Zobrazit zůstatek.");
        System.out.println("2. Vybrat hotovost.");
        System.out.println("3. Vložit hotovost.");
        System.out.println("4. Odhlásit uživatele.");
        System.out.println("Pro volbu zadejte číslo.");
        System.out.println("");
    }

    private static void prihlasenyUzivatel(Klient klient) {
        boolean uzivatelPrihlasen = true;
        while (uzivatelPrihlasen == true) {
            vypisMenuPrihlasenehoUzivatele();
            int volba = zadejInt();
            switch (volba) {
                case 1:
                    System.out.println("");
                    System.out.println("Aktuální zůstatek na účtě je: ");
                    System.out.println(klient.getZustatek() + " Kč.");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Jakou částku si přejete vybrat? Maximalní výběr je " + MAX_VYBER + " Kč.");
                    int vyber = zadejKladnyInt();
                    if (vyber > MAX_VYBER) {
                        System.out.println("Omlouváme se, ale nejde vybrat větší částku než " + MAX_VYBER + " Kč.");
                        break;
                    }
                    if ((klient.getZustatek() - vyber) >= 0) {
                        klient.setZustatek(klient.getZustatek() - vyber);
                        System.out.println("Peníze byli strženy z účtu.");
                    } else {
                        System.out.println("Na účtě není dostatek prostředků na výběr částky.");
                    }
                    break;
                case 3:
                    System.out.println("Jakou částku si přejete vložit na účet?");
                    int castka = zadejKladnyInt();
                    klient.setZustatek(klient.getZustatek() + castka);
                    System.out.println("Peníze byly vloženy na účet.");
                    break;

                case 4:
                    uzivatelPrihlasen = false;
                    System.out.println("");
                    System.out.println("Uživatel odhlášen.");
                    System.out.println("");
                    break;
            }
        }
    }
}
