package org.examples.lox;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    final Environment enclosing;
    private final Map<String, Object> values = new HashMap<>();

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    Environment() {
        this.enclosing = null;
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }

        if (enclosing != null) {
            return enclosing.get(name);
        }

        throw new RuntimeError(name,
                String.format("Undefined variable '%s'.", name.lexeme));
    }

    void define(String name, Object value) {
        values.put(name, value);
    }


    public void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
            return;
        }

        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeError(name,
                String.format("Undefined variable '%s'.", name.lexeme));
    }

    public Object getAt(Integer distance, String name) {
        return ancestor(distance).values.get(name);
    }

    private Environment ancestor(Integer distance) {
        Environment environment = this;

        for (int i = 0; i < distance; i++) {
            environment = environment.enclosing;
        }

        return environment;
    }

    public void assignAt(Integer distance, Token name, Object value) {
        ancestor(distance).values.put(name.lexeme, value);
    }

}
