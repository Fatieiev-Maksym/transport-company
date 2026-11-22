package org.example;

/**
 * Кінцевий клас 2: велика вантажівка для великих партій.
 * Має поле типу Engine (композиція: вантажівка МАЄ двигун).
 */
public final class Truck extends Vehicle
{
    private final Engine engine;

    public Truck(String name, int maxLoadKg, Engine engine)
    {
        super(name, maxLoadKg);
        this.engine = engine;
        System.out.println("[Truck] Конструктор: вантажівка '" + name + "' готова до роботи");
    }

    @Override
    public void deliver(int km)
    {
        System.out.println("[Truck.deliver] Вантажівка '" + getName() + "' виїжджає зі складу");
        if (currentLoadKg == 0)
        {
            System.out.println("[Truck.deliver] Нічого везти, вантажівка лишається на місці");
            return;
        }
        engine.start();
        System.out.println("[Truck.deliver] Їде " + km + " км до логістичного центру з вантажем "
                + currentLoadKg + " кг");
        engine.stop();
        unload();
    }
}
