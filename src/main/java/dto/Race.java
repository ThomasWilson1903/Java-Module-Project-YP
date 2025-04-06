package dto;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Race {
    private Car carWinner;
    private final int MIN_CAR_SPEED = 0;
    private final int MAX_CAR_SPEED = 250;


    public void definingLeader(int quantity) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= quantity; i++) {
            System.out.println("— Введите название машины №" + i + ":");
            String name = scanner.next();
            Car car = new Car(getSpeed(scanner, i), name);

            if (carWinner == null) {
                this.carWinner = car;
                continue;
            }

            if (this.carWinner.speed < car.speed) carWinner = car;

        }
    }

    private int getSpeed(Scanner scanner, int number) {
        System.out.println("— Введите скорость машины №" + number + ": ");
        try {
            int speed = scanner.nextInt();

            if (speed <= MIN_CAR_SPEED || speed > MAX_CAR_SPEED) {
                System.out.println("— Неправильная скорость");
                speed = getSpeed(scanner, number);
            }
            return speed;
        } catch (InputMismatchException e) {
            System.out.println("Введено неверное значение, число должно быть целым от " + MIN_CAR_SPEED + " до " + MAX_CAR_SPEED);
            scanner.nextLine();
            return getSpeed(scanner, number);
        } catch (Exception e) {
            System.out.println("При чтении произошла неизвестная ошибка");
            throw e;
        }
    }

    @Override
    public String toString() {
        return "Самая быстрая машина: " + this.carWinner.name;
    }
}
