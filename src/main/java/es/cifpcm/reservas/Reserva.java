package es.cifpcm.reservas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2dawb
 */
public class Reserva {
    private int hotel;
    private int nights;
    private int total;

    public Reserva(int hotel, int nights) {
        this.hotel = hotel;
        this.nights = nights;
    }
    
    public void setTotal(int total){
        this.total = total;
    }

    public int getHotel() {
        return hotel;
    }

    public int getNights() {
        return nights;
    }

    public int getTotal() {
        return total;
    }
    
    
}

