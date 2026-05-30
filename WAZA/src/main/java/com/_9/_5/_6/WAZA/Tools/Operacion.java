package com._9._5._6.WAZA.Con;

package com.waza.Tools;

import java.util.Stack;

public class Operacion {

    public static String convertirPostfix(String infix) {

        StringBuilder salida = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {

            char c = infix.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                salida.append(c).append(" ");
            }
            else if (c == '(') {
                pila.push(c);
            }
            else if (c == ')') {

                while (!pila.isEmpty() && pila.peek() != '(') {
                    salida.append(pila.pop()).append(" ");
                }

                pila.pop();
            }
            else {

                while (!pila.isEmpty()
                        && prioridad(pila.peek()) >= prioridad(c)) {

                    salida.append(pila.pop()).append(" ");
                }

                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            salida.append(pila.pop()).append(" ");
        }

        return salida.toString().trim();
    }

    public static String resolver(String postfix) {

        Stack<Integer> pila = new Stack<>();

        String[] tokens = postfix.split(" ");

        for (String token : tokens) {

            if (token.matches("\\d+")) {

                pila.push(Integer.parseInt(token));

            } else {

                int b = pila.pop();
                int a = pila.pop();

                switch (token) {

                    case "+":
                        pila.push(a + b);
                        break;

                    case "-":
                        pila.push(a - b);
                        break;

                    case "*":
                        pila.push(a * b);
                        break;

                    case "/":
                        pila.push(a / b);
                        break;
                }
            }
        }

        return String.valueOf(pila.pop());
    }

    private static int prioridad(char operador) {

        if (operador == '*' || operador == '/') {
            return 2;
        }

        if (operador == '+' || operador == '-') {
            return 1;
        }

        return 0;
    }
}