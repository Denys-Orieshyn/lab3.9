package org.example;

/**
 * Вузол-лісток, який представляє змінну (її ім'я) у виразі.
 * <p>
 * При обчисленні шукає значення змінної у переданій мапі {@code variables}.
 */
public class VariableNode implements ExpressionNode {
    private final String name;

    /**
     * Створює вузол для змінної з вказаним іменем.
     *
     * @param name ім'я змінної (наприклад, "x")
     */
    public VariableNode(String name) {
        this.name = name;
    }

    /**
     * Повертає ім'я змінної як рядок.
     *
     * @return ім'я змінної
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Обчислює значення змінної, беручи його з мапи {@code variables}.
     *
     * @param variables мапа, в якій має бути ключ із ім'ям цієї змінної
     * @return значення змінної з мапи
     * @throws IllegalArgumentException якщо мапа не містить значення для цієї змінної
     */
    @Override
    public double evaluate(java.util.Map<String, Double> variables) {
        if (!variables.containsKey(name)) {
            throw new IllegalArgumentException("Змінна " + name + " не знайдена у мапі");
        }
        return variables.get(name);
    }
}
