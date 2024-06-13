import java.util.Stack;

public class Etapa3 {
    /**
        Verifica se uma expressão matemática tem os parênteses agrupados de forma correta.
     */
    public boolean checkBrackets(Stack<Character> s1) {
        if (s1.isEmpty()) {
            return true;
        }
        int openCount = 0;
        int closeCount = 0;
        while (!s1.isEmpty()) {
            char c = s1.pop();
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                closeCount++;
                if (openCount < closeCount) {
                    return false;
                }
            }
        }
        return openCount == closeCount;
    }
}