package org.example;

/**
 * Інтерфейс-контракт: усе, що можна завантажити товаром,
 * повинно вміти завантажуватись і розвантажуватись.
 * Методи інтерфейсу неявно public abstract.
 */
public interface Loadable
{
    void load(int kg);

    void unload();
}
