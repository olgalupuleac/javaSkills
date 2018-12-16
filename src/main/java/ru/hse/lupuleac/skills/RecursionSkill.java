package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class RecursionSkill extends Skill {
    @Override
    public String toString() {
        return "RECURSION";
    }

    @Override
    public void visit(MethodDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        String name = n.getNameAsString();
        n.getChildNodes().stream().peek(System.out::println).filter(x -> x instanceof MethodCallExpr)
                .map(x -> ((MethodCallExpr) x)).forEach(x -> matchMethodCall("(.*)\\." + name, x, arg));
    }
}
