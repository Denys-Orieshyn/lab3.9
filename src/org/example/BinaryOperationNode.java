package org.example;

/**
 * Вузол-композит, який представляє бінарну операцію між двома підвиразами.
 * <p>
 * Містить посилання на лівий та правий підвузли типу {@code ExpressionNode}
 * та символ оператора (наприклад, '+', '-', '*', '/').
 * {@code toString()} будує інфіксну нотацію з дужками,
 * {@code evaluate(Map)} рекурсивно обчислює значення лівого та правого підвиразів
 * і застосовує відповідну арифметичну операцію.
 */
public class BinaryOperationNode implements ExpressionNode {
    private final ExpressionNode left;
    private final ExpressionNode right;
    private final char operator;

    /**
     * Створює бінарний вузол.
     *
     * @param left     лівий підвираз
     * @param operator символ оператора ('+', '-', '*', '/')
     * @param right    правий підвираз
     */
    public BinaryOperationNode(ExpressionNode left, char operator, ExpressionNode right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    /**
     * Повертає інфіксне рядкове представлення виразу у дужках,
     * наприклад {@code "(x + 5)"} або {@code "((x + 5) * (y - 2))"}.
     *
     * @return рядкове представлення бінарної операції
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
    }

    /**
     * Обчислює значення виразу: рекурсивно обчислює ліву та праву частини та
     * застосовує арифметичний оператор.
     *
     * @param variables мапа значень змінних для підставлення при обчисленні
     * @return результат виконання операції над обчисленими підвиразами
     * @throws IllegalArgumentException при невідомому операторі або при діленні на нуль
     */
    @Override
    public double evaluate(java.util.Map<String, Double> variables) {
        double leftValue = left.evaluate(variables);
        double rightValue = right.evaluate(variables);

        switch (operator) {
            case '+': return leftValue + rightValue;
            case '-': return leftValue - rightValue;
            case '*': return leftValue * rightValue;
            case '/':
                if (rightValue == 0.0) {
                    throw new IllegalArgumentException("Ділення на нуль у виразі");
                }
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Невідомий оператор: " + operator);
        }
    }
}
