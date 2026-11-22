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

        // Ранок: компанія формує автопарк
        System.out.println("--- Ранок: автопарк ---");
        Engine truckEngine = new Engine(400);
        Vehicle van = new Van("Ford Transit", 1000);                 // поліморфізм:
        Vehicle truck = new Truck("MAN TGX", 5000, truckEngine);     // змінна типу батька, об'єкт нащадка
        Vehicle.getVehicleCount();                                   // виклик static-методу через клас

        // Дрібне замовлення їде фургоном
        System.out.println("\n--- Замовлення 1: дрібні товари ---");
        van.load(800);
        van.load(500);      // забагато, фургон не вмістить
        van.deliver(30);

        // Велика партія їде вантажівкою
        System.out.println("\n--- Замовлення 2: велика партія ---");
        truck.load(3000);
        truck.load(2500);   // забагато
        truck.load(1500);
        truck.deliver(120);

        // Вечір: один і той самий код працює з різними машинами
        System.out.println("\n--- Вечір: останній рейс усіх машин ---");
        Vehicle[] fleet = {van, truck};
        for (Vehicle v : fleet)
        {
            v.load(200);
            v.deliver(10);  // у Van і Truck виконується різний код
        }

        System.out.println();
        Vehicle.getVehicleCount();
        System.out.println("\n=== Робочий день завершено ===");
    }
}
