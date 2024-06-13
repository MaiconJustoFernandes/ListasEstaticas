import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // Testes para o método contaElementos
        StaticList<Integer> lista = new StaticList<>(5);
        try {
            lista.insert(1, 0);
            lista.insert(2, 1);
            lista.insert(1, 2);
            lista.insert(3, 3);
            lista.insert(1, 4);
        } catch (OverflowException | IndexOutOfBoundsException e) {
            System.err.println("Erro ao inserir elementos na lista: " + e.getMessage());
        }

        System.out.println("Lista: " + lista);

        int ocorrencias1 = lista.contaElementos(1);
        System.out.println("Ocorrencias do elemento 1: " + ocorrencias1);

        int ocorrencias2 = lista.contaElementos(2);
        System.out.println("Ocorrencias do elemento 2: " + ocorrencias2);

        // Testes para o método checkBrackets
        Stack<Character> pilha1 = new Stack<>();
        pilha1.push(')');
        pilha1.push('(');
        pilha1.push('+');
        pilha1.push('B');
        pilha1.push('A');

        Stack<Character> pilha2 = new Stack<>();
        pilha2.push(')');
        pilha2.push('(');
        pilha2.push('+');
        pilha2.push('B');
        pilha2.push('A');
        pilha2.push('(');

        Etapa3 etapa3 = new Etapa3();

        System.out.println("Expressão 1 válida? " + etapa3.checkBrackets(pilha1)); // Saída: false
        System.out.println("Expressão 2 válida? " + etapa3.checkBrackets(pilha2)); // Saída: true
    }
}

class Etapa3 {

    public boolean checkBrackets(Stack<Character> s1) {
        int countOpen = 0;
        int countClose = 0;

        while (!s1.isEmpty()) {
            char c = s1.pop();
            if (c == '(') {
                countOpen++;
            } else if (c == ')') {
                countClose++;
                if (countOpen < countClose) {
                    return false; // Regra 2 violada
                }
            }
        }

        return countOpen == countClose; // Regra 1 verificada
    }
}
