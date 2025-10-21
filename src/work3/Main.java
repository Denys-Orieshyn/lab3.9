package work3;


/**
 * Main — демонстрація мінімальної структури Flyweight.
 *
 * <p>Створює фабрику, два рядки та викликає друк.
 * Код призначений лише для демонстрації архітектури патерну.</p>
 *
 * @author Денис
 * @since 1.0
 */
public class Main {
    /**
     * Точка входу. Запускає демонстрацію.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        TextLine line1 = new TextLine("HELLO", factory);
        TextLine line2 = new TextLine("WORLD", factory);

        line1.print();
        line2.print();
    }
}
