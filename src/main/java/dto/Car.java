package dto;

public class Car {
    public final int speed;
    public final String name;


    public Car(int speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", name='" + name + '\'' +
                '}';
    }
}
