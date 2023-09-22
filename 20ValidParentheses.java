/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
*/

/*
Creiamo una pila (stack) vuota chiamata stack.

Iteriamo attraverso ogni carattere nella stringa s usando un ciclo for-each:

a. Se il carattere è una parentesi aperta ('(', '{', o '['), lo mettiamo nella pila per tenerne traccia.

b. Se il carattere è una parentesi chiusa (')', '}', o ']'), dobbiamo controllare se corrisponde all'ultima parentesi aperta nella pila. Per farlo, verifichiamo se la pila non è vuota e se l'elemento in cima alla pila è della stessa categoria della parentesi chiusa.
Se ciò è vero, rimuoviamo l'elemento dalla pila. In caso contrario, la stringa è considerata non valida.

c. Se il carattere non è né una parentesi aperta né una parentesi chiusa, la stringa è considerata non valida.

Alla fine del ciclo, se la pila è vuota, significa che tutte le parentesi aperte hanno corrispondenti parentesi chiuse, e quindi la stringa è considerata valida. Altrimenti, se la pila non è vuota, ciò significa che ci sono parentesi aperte che non sono state chiuse correttamente, e la stringa è considerata non valida.
*/

class 20ValidParentheses {
    public boolean isValid(String s) {

          Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Found an invalid character
            }
        }

        return stack.isEmpty(); // If the stack is empty, all brackets are matched.
    }
        
    }

