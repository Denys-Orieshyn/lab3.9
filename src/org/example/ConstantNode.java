package org.example;

/**
 * Вузол-лісток, який представляє числову константу у виразі.
 * <p>
 * Повертає своє значення як у вигляді рядка (через {@code toString()}), так і при обчисленні
 * (через {@code evaluate(Map)}).
 */
public class ConstantNode implements ExpressionNode {
    private final double value;

    /**
     * Створює новий вузол-константу.
     *
     * @param value значення константи
     */
    public ConstantNode(double value) {
        this.value = value;
    }

    /**
     * Повертає рядкове представлення константи (наприклад, {@code "5.0"}).
     *
     * @return рядок з числовим значенням
     */
    @Override
    public String toString() {
        return Double.toString(value);
    }

    /**
     * Повертає числове значення константи.
     *
     * @param variables не використовується, але передається для узгодженості інтерфейсу
     * @return значення константи
     */
    @Override
    public double evaluate(java.util.Map<String, Double> variables) {
        return value; // просто повертає своє значення
    }
}
