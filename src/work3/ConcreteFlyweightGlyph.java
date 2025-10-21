package work3;


/**
 * ConcreteFlyweight — конкретна реалізація Flyweight.
 *
 * <p>Зберігає інтринзичний стан у вигляді символа. Не зберігає координат.
 * Метод {@link #operation(int,int)} приймає екстринзичний стан і виконує дію
 * для цього екземпляра символа.</p>
 *
 * @author Денис
 * @since 1.0
 */
public class ConcreteFlyweightGlyph implements IFlyweight {
    /**
     * Інтринзичний стан: символ, який спільно використовується.
     * Робить об'єкт легким для дублювання в пам'яті.
     */
    private final char symbol;

    /**
     * Створює ConcreteFlyweight з конкретним символом.
     *
     * @param symbol символ який представляє цей flyweight (наприклад 'A', ' ')
     */
    public ConcreteFlyweightGlyph(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Виконує дію з екстринзичним станом.
     *
     * <p>У простому прикладі виводиться інформація в консоль.
     * У реальному застосунку тут може бути виклик графічного API.</p>
     *
     * @param x координата X екстринзичного стану
     * @param y координата Y екстринзичного стану
     */
    @Override
    public void operation(int x, int y) {
        System.out.println("Символ '" + symbol + "' у координатах (" + x + "," + y + ")");
    }

    /**
     * Повертає символ цього flyweight.
     *
     * @return символ (інтринзичний стан)
     */
    public char getSymbol() {
        return symbol;
    }
}
