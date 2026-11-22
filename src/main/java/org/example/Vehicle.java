package org.example;

/**
 * Абстрактний клас: загальна основа будь-якого транспорту компанії.
 * Створити об'єкт Vehicle через new неможливо.
 */
public abstract class Vehicle implements Loadable
{
    // static: одне значення на весь клас, а не на кожен об'єкт
    private static int vehicleCount = 0;

    private final String name;        // private: доступ лише через getName()
    private final int maxLoadKg;      // вантажопідйомність
    protected int currentLoadKg;      // protected: бачать нащадки

    protected Vehicle(String name, int maxLoadKg)
    {
        this.name = name;
        this.maxLoadKg = maxLoadKg;
        this.currentLoadKg = 0;
        vehicleCount++;
        System.out.println("[Vehicle] Конструктор: '" + name + "' додано до автопарку, макс. вантаж "
                + maxLoadKg + " кг");
    }

    public static int getVehicleCount()
    {
        System.out.println("[Vehicle.getVehicleCount] Машин в автопарку: " + vehicleCount);
        return vehicleCount;
    }

    public String getName()
    {
        return name;
    }

    // Абстрактний метод: тіла немає, кожен нащадок зобов'язаний реалізувати його по-своєму
    public abstract void deliver(int km);

    // Спільна реалізація методів інтерфейсу Loadable
    @Override
    public void load(int kg)
    {
        System.out.println("[Vehicle.load] '" + name + "': спроба завантажити " + kg + " кг");
        if (currentLoadKg + kg > maxLoadKg)
        {
            System.out.println("[Vehicle.load] Перевантаження! Вільно лише "
                    + (maxLoadKg - currentLoadKg) + " кг. Товар залишається на складі");
        }
        else
        {
            currentLoadKg += kg;
            System.out.println("[Vehicle.load] Завантажено. Зараз у кузові: " + currentLoadKg + " кг");
        }
    }

    @Override
    public void unload()
    {
        System.out.println("[Vehicle.unload] '" + name + "': розвантажено " + currentLoadKg
                + " кг у логістичному центрі");
        currentLoadKg = 0;
    }
}
