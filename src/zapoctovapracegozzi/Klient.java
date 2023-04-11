/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zapoctovapracegozzi;

/**
 *
 * @author Alessandro
 */
public class Klient {

    private String jmeno;
    private final long cisloUctu;
    private int pin;
    private double zustatek;

    public Klient(String jmeno, long cisloUctu, int pin, double zustatek) {
        this.jmeno = jmeno;
        this.cisloUctu = cisloUctu;
        this.pin = pin;
        this.zustatek = zustatek;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setZustatek(double zustatek) {
        this.zustatek = zustatek;
    }

    public String getJmeno() {
        return jmeno;
    }

    public long getCisloUctu() {
        return cisloUctu;
    }

    public int getPin() {
        return pin;
    }

    public double getZustatek() {
        return zustatek;
    }

}
