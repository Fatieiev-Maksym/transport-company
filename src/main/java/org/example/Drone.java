package org.example;

/**
 * Кінцевий клас 3: дрон для найдрібніших посилок.
 * Двигуна (Engine) не має, працює від акумулятора: власне поле batteryPercent.
 */
public final class Drone extends Vehicle
{
    private static final int BATTERY_PER_KM = 2;   // % заряду на 1 км

    private int batteryPercent;

    public Drone(String name, int maxLoadKg)
    {
        super(name, maxLoadKg);
        this.batteryPercent = 100;
        System.out.println("[Drone] Конструктор: дрон '" + name + "' готовий, заряд "
                + batteryPercent + "%");
    }

    @Override
    public void deliver(int km)
    {
        System.out.println("[Drone.deliver] Дрон '" + getName() + "' злітає зі складу");
        if (currentLoadKg == 0)
        {
            System.out.println("[Drone.deliver] Нічого везти, дрон лишається на місці");
            return;
        }
        int needed = km * BATTERY_PER_KM;
        if (needed > batteryPercent)
        {
            System.out.println("[Drone.deliver] Заряду не вистачить: потрібно " + needed
                    + "%, є " + batteryPercent + "%. Дрон лишається на місці");
            return;
        }
        System.out.println("[Drone.deliver] Летить " + km + " км до логістичного центру з вантажем "
                + currentLoadKg + " кг");
        batteryPercent -= needed;
        System.out.println("[Drone.deliver] Залишок заряду: " + batteryPercent + "%");
        unload();
    }
}
