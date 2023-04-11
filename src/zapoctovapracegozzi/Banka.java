/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zapoctovapracegozzi;

/**
 *
 * @author Alessandro
 */
public class Banka {

    static Klient[] poleKlientu = {
        new Klient("Novak", 123456789, 1234, 20000),
        new Klient("Novotny", 999999999, 9999, 1000000),
        new Klient("Kovar", 987654321, 4545, 15000),
        new Klient("Svobodny", 111111111, 1586, 35000),
        new Klient("Dvorak", 222222222, 5462, 45000)
    };

    public static boolean autentikace(long cisloUctu, int pin) {

        boolean udajeSouhlasi = false;
        for (int i = 0; i < poleKlientu.length; i++) {
            if ((poleKlientu[i].getCisloUctu() == cisloUctu) && (poleKlientu[i].getPin() == pin)) {
                udajeSouhlasi = true;
            }
        }
        return udajeSouhlasi;
    }

    public static Klient odeslaniKlientaDoBankomatu(long cisloUctu, int pin) {
        Klient klient;
        int cisloKlienta = 0;
        for (int i = 0; i < poleKlientu.length; i++) {
            if ((poleKlientu[i].getCisloUctu() == cisloUctu) && (poleKlientu[i].getPin() == pin)) {
                cisloKlienta = i;
            }
        }
        klient = poleKlientu[cisloKlienta];
        return klient;
    }
}
