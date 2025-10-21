package work3;
// TextLine.java
import java.util.ArrayList;
import java.util.List;

/**
 * TextLine — простий композитний об'єкт, що представляє рядок тексту.
 *
 * <p>Замість створення окремих важких об'єктів для кожного символа,
 * TextLine зберігає посилання на спільні flyweight-об'єкти, отримані від фабрики,
 * і передає екстринзичні координати під час виклику {@link IFlyweight#operation(int,int)}.</p>
 *
 * <p>Цей клас демонструє клієнтську частину патерну Flyweight.</p>
 *
 * @author Денис
 * @since 1.0
 */
public class TextLine {
    /**
     * Послідовність flyweight-об'єктів (кожен представляє символ).
     * В реальному випадку можна зберігати також екстринзичний стан поруч,
     * але для прикладу координати генеруються в методі {@link #print()}.
     */
    private final List<IFlyweight> glyphs = new ArrayList<>();

    /**
     * Створює TextLine з рядка, отримуючи flyweight-об'єкти з фабрики.
     *
     * @param text    текст рядка (латиниця або пробіли)
     * @param factory фабрика для отримання спільних гліфів
     */
    public TextLine(String text, FlyweightFactory factory) {
        for (char c : text.toCharArray()) {
            glyphs.add(factory.getFlyweight(c));
        }
    }

    /**
     * Виводить рядок шляхом виклику операції у кожного flyweight.
     *
     * <p>Координати тут прості: X інкрементується для кожного символа,
     * Y фіксований. Це приклад екстринзичного стану.</p>
     */
    public void print() {
        int x = 0;
        for (IFlyweight g : glyphs) {
            g.operation(x++, 0);
        }
    }
}
