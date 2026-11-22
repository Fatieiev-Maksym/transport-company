package org.example;

/**
 * Окремий клас: двигун. Ні від кого не наслідується,
 * використовується як поле в класі Truck (композиція).
 */
public class Engine
{
    private final int horsePower;
    private boolean running;

    public Engine(int horsePower)
    {
        this.horsePower = horsePower;
        this.running = false;
        System.out.println("[Engine] Створено двигун, потужність " + horsePower + " к.с.");
    }

    public void start()
    {
        running = true;
        System.out.println("[Engine.start] Двигун " + horsePower + " к.с. запущено");
    }

    public void stop()
    {
        running = false;
        System.out.println("[Engine.stop] Двигун зупинено");
    }
}
