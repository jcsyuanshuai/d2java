package org.example.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 编程语言的编译过程可以划分为四个阶段
 * 词法分析: 切分code text 为 token
 * |
 * 语法分析：
 */
public class Lox {
    static boolean hadError = false;
    static boolean hadRuntimeError = false;

    private static final Interpreter interpreter = new Interpreter();

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));

        run(new String(bytes, Charset.defaultCharset()));

        if (hadError) {
            System.exit(65);
        }

        if (hadRuntimeError) {
            System.exit(70);
        }
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        while (true) {
            System.out.print("> ");
            String line = reader.readLine();

            if (line == null) {
                break;
            }

            run(line);

            hadError = false;
        }
    }

    private static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        // fixme
        System.out.println("===========================切分token============================");
        for (Token token : tokens) {
            System.out.println(token);
        }
        System.out.println();

        Parser parser = new Parser(tokens);
        List<Stmt> stmts = parser.parse();

        // fixme
        System.out.println("===========================转为AST=============================");
        for (Stmt stmt : stmts) {
            AstPrinter printer = new AstPrinter();
            System.out.println(printer.print(stmt));
        }
        System.out.println();

        if (hadError) {
            return;
        }

        Resolver resolver = new Resolver(interpreter);
        resolver.resolve(stmts);

        // fixme
        System.out.println("===========================语法检查=============================");
        for (Stmt stmt : stmts) {
            AstPrinter printer = new AstPrinter();
            System.out.println(printer.print(stmt));
        }
        System.out.println();

        if (hadError) {
            return;
        }

        interpreter.interpret(stmts);

    }

    static void error(int line, String message) {
        report(line, "", message);
    }

    static void error(Token token, String message) {
        if (token.type == TokenType.EOF) {
            report(token.line, " at end", message);
        } else {
            report(token.line, " at '" + token.lexeme + "'", message);
        }
    }

    private static void report(int line, String where, String message) {
        System.err.printf("[line %d] Error %s: %s%n", line, where, message);
        hadError = true;
    }

    static void runtimeError(RuntimeError error) {
        System.err.printf("%s\n[line %d]\n", error.getMessage(), error.token.line);
        hadRuntimeError = true;
    }
}
