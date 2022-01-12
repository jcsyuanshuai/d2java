package org.example.lox;

import java.util.HashMap;
import java.util.Map;

public class LoxInstance {
    private LoxClass clazz;
    private final Map<String, Object> fields = new HashMap<>();

    public LoxInstance(LoxClass clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "LoxInstance{" +
                "clazz=" + clazz.name +
                '}';
    }

    public Object get(Token name) {
        if (fields.containsKey(name.lexeme)) {
            return fields.get(name.lexeme);
        }

        LoxFunction method = clazz.findMethod(name.lexeme);
        if (method != null) {
            return method.bind(this);
        }

        throw new RuntimeError(name,
                String.format("Undefined property '%s'.", name.lexeme));
    }

    public void set(Token name, Object value) {
        fields.put(name.lexeme, value);
    }
}
