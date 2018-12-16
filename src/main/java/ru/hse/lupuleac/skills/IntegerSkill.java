package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class IntegerSkill extends Skill {
    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        matchMethodCall("java\\.lang\\.Integer\\.(.*)", n ,arg);
    }

    @Override
    public String toString() {
        return "INTEGER";
    }
}
