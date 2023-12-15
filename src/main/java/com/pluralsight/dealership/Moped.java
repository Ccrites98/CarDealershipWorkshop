package com.pluralsight;
class Moped extends Vehicle {
    private boolean isShortDistance;
    private boolean isEasyToOperate;
    private boolean isSmall;
    private int numberOfWheels;
    private boolean isExposedRider;

    public Moped(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity,
                 boolean isShortDistance, boolean isEasyToOperate,
                 boolean isSmall, int numberOfWheels, boolean isExposedRider) {
        this.isShortDistance = isShortDistance;
        this.isEasyToOperate = isEasyToOperate;
        this.isSmall = isSmall;
        this.numberOfWheels = numberOfWheels;
        this.isExposedRider = isExposedRider;
    }
    public Moped() {
        super();
    }
    public boolean isShortDistance() {
        return isShortDistance;
    }
    public boolean isEasyToOperate() {
        return isEasyToOperate;
    }
    public boolean isSmall() {
        return isSmall;
    }
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    public boolean isExposedRider() {
        return isExposedRider;
    }

    public class Main {
        public static void main(String[] args) {
            Moped slowRider = new Moped("Red", 2, 10, 5, false, false, false, 2, false);
            slowRider.setColor("Red");
            slowRider.setNumberOfPassengers(2);
            slowRider.setCargoCapacity(10);
            slowRider.setFuelCapacity(5);
            slowRider.isSmall(true);
            System.out.println("Moped Color: " + slowRider.getColor());
            System.out.println("Number of Passengers: " + slowRider.getNumberOfPassengers());
            System.out.println("Cargo Capacity: " + slowRider.getCargoCapacity());
            System.out.println("Fuel Capacity: " + slowRider.getFuelCapacity());
            System.out.println("Small: " + slowRider.isSmall());
        }}
    private boolean isSmall(boolean b) {
        return true;
    }
}