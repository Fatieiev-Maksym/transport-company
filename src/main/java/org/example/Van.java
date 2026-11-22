package org.example;

/**
 * Кінцевий клас 1: невеликий фургон для дрібних замовлень.
 * final: від цього класу вже не можна наслідуватись.
 * Має поле типу Engine (композиція: фургон МАЄ двигун).
 */
public final class Van extends Vehicle
{
    private final Engine engine;

    public Van(String name, int maxLoadKg, Engine engine)
    {
        super(name, maxLoadKg);   // спершу конструктор батьківського класу
        this.engine = engine;
        System.out.println("[Van] Конструктор: фургон '" + name + "' готовий до роботи");
    }

    @Override
    public void deliver(int km)
    {
        System.out.println("[Van.deliver] Фургон '" + getName() + "' виїжджає зі складу");
        if (currentLoadKg == 0)
        {
            System.out.println("[Van.deliver] Нічого везти, фургон лишається на місці");
            return;
        }
        engine.start();
        System.out.println("[Van.deliver] Їде " + km + " км до логістичного центру з вантажем "
                + currentLoadKg + " кг");
        engine.stop();
        unload();
    }
}
