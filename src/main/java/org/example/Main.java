package org.example;

/**
 * Історія: один робочий день транспортної компанії "Швидкий шлях",
 * яка розвозить товари зі складу до логістичного центру.
 */
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("=== Один робочий день компанії 'Швидкий шлях' ===\n");

        // Ранок: компанія купує двигуни та формує автопарк
        System.out.println("--- Ранок: автопарк ---");
        Engine vanEngine = new Engine(150);
        Engine truckEngine = new Engine(400);
        Vehicle drone = new Drone("Sky-1", 5);                        // поліморфізм: змінна типу батька,
        Vehicle van = new Van("Ford Transit", 1000, vanEngine);       // а об'єкти різних нащадків
        Vehicle truck = new Truck("MAN TGX", 5000, truckEngine);
        Vehicle.getVehicleCount();                                    // static-метод викликається через клас

        // Замовлення 1: документи та дрібні деталі везе дрон
        System.out.println("\n--- Замовлення 1: дрібна посилка ---");
        drone.load(3);
        drone.load(4);      // забагато, дрон не підніме
        drone.deliver(5);

        // Замовлення 2: середня партія їде фургоном
        System.out.println("\n--- Замовлення 2: середня партія ---");
        van.load(800);
        van.load(500);      // забагато, фургон не вмістить
        van.deliver(30);

        // Замовлення 3: велика партія їде вантажівкою
        System.out.println("\n--- Замовлення 3: велика партія ---");
        truck.load(3000);
        truck.load(2500);   // забагато
        truck.load(1500);
        truck.deliver(120);

        // Вечір: один і той самий код працює з усіма машинами, а поведінка різна
        System.out.println("\n--- Вечір: останній рейс усіх машин із маленьким вантажем ---");
        Vehicle[] fleet = {drone, van, truck};
        for (Vehicle v : fleet)
        {
            v.load(2);
            v.deliver(10);  // Drone, Van і Truck виконують кожен свій deliver()
        }

        System.out.println();
        Vehicle.getVehicleCount();
        System.out.println("\n=== Робочий день завершено ===");
    }
}
