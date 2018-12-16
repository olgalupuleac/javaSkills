package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ConcurrencySkill extends Skill {
    @Override
    public String toString() {
        return "CONCURRENCY";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        matchMethodCall("java\\.util\\.concurrent\\.(.*)", n, arg);
    }
}
