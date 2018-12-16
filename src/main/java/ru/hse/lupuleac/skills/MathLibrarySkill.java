package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class MathLibrarySkill extends Skill {
    @Override
    public String toString() {
        return "MATH_LIBRARY";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        matchMethodCall("java\\.lang\\.Math\\.(.*)", n, arg);
    }
}
