package org.example;

/**
 * Кінцевий клас 2: велика вантажівка для великих партій.
 * Має поле типу Engine (композиція: вантажівка МАЄ двигун).
 * Відмінність від Van: порожню або майже порожню вантажівку не відправляють у рейс.
 */
public final class Truck extends Vehicle
{
    // static final: константа, одна на весь клас
    private static final int MIN_LOAD_KG = 1000;

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
        if (currentLoadKg < MIN_LOAD_KG)
        {
            System.out.println("[Truck.deliver] Вантажу лише " + currentLoadKg + " кг (мінімум "
                    + MIN_LOAD_KG + " кг). Рейс невигідний, вантажівка чекає більшу партію");
            return;
        }
        engine.start();
        System.out.println("[Truck.deliver] Їде " + km + " км до логістичного центру з вантажем "
                + currentLoadKg + " кг");
        engine.stop();
        unload();
    }
}
