package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class IteratorSkill extends Skill {
    @Override
    public String toString() {
        return "ITERATOR";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        matchMethodCall("java\\.util\\.Iterator\\.(.*)", n, arg);
    }
}
