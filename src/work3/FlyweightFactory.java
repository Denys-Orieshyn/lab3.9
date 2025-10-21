package work3;

// FlyweightFactory.java
import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory — простий кеш для flyweight-об'єктів.
 *
 * <p>Повертає один і той самий {@link ConcreteFlyweightGlyph} для одного символа.
 * Це забезпечує економію пам'яті при великій кількості однакових символів.</p>
 *
 * <p>Примітка: поточна реалізація не оптимізована для конкурентного доступу.
 * Для багатопотокових середовищ слід використовувати {@code ConcurrentHashMap} або
 * синхронізувати доступ.</p>
 *
 * @author Денис
 * @since 1.0
 */
public class FlyweightFactory {
    /**
     * Пул спільних об'єктів. Ключ — символ, значення — flyweight.
     */
    private final Map<Character, IFlyweight> pool = new HashMap<>();

    /**
     * Повертає існуючий flyweight для символа або створює новий, якщо ще нема.
     *
     * @param key символ, який ідентифікує flyweight
     * @return екземпляр {@link IFlyweight} пов'язаний з цим символом
     */
    public IFlyweight getFlyweight(char key) {
        if (!pool.containsKey(key)) {
            pool.put(key, new ConcreteFlyweightGlyph(key));
        }
        return pool.get(key);
    }
}
