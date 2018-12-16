package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class BigIntegerSkill extends Skill {
    @Override
    public String toString() {
        return "BIG_INTEGER";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        matchMethodCall("java\\.math\\.BigInteger(.*)", n, arg);
    }
}
