package org.example;

import java.util.Map;

/**
 * Точка входу програми, яка демонструє роботу дерева розбору виразу.
 * <p>
 * У методі {@code main} показані приклади:
 * <ol>
 *   <li>простий вираз — константа;</li>
 *   <li>простий вираз — змінна;</li>
 *   <li>складний вираз з двома підвиразами (бінарна операція);</li>
 *   <li>вкладений складний вираз (комбія бінарних операцій).</li>
 * </ol>
 * Кожен приклад друкує текстове представлення виразу (через {@code toString()})
 * та результат його обчислення (через {@code evaluate(Map)}).
 */
public class Main {
    public static void main(String[] args) {
        // 1. Простий вираз — константа
        ExpressionNode constExpr = new ConstantNode(5);
        System.out.println(constExpr + " = " + constExpr.evaluate(Map.of()));

        // 2. Простий вираз — змінна
        ExpressionNode varExpr = new VariableNode("x");
        System.out.println(varExpr + " = " + varExpr.evaluate(Map.of("x", 10.0)));

        // 3. Складний вираз (x + 5)
        ExpressionNode sumExpr = new BinaryOperationNode(varExpr, '+', constExpr);
        System.out.println(sumExpr + " = " + sumExpr.evaluate(Map.of("x", 10.0)));

        // 4. Вкладений вираз ((x + 5) * (y - 2))
        ExpressionNode left = new BinaryOperationNode(new VariableNode("x"), '+', new ConstantNode(5));
        ExpressionNode right = new BinaryOperationNode(new VariableNode("y"), '-', new ConstantNode(2));
        ExpressionNode complex = new BinaryOperationNode(left, '*', right);

        System.out.println(complex + " = " + complex.evaluate(Map.of("x", 3.0, "y", 6.0)));
    }
}
