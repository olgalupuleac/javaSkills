package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ReflectionSkill extends Skill {
    @Override
    public String toString() {
        return "REFLECTION";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        matchMethodCall("java\\.lang\\.reflect(.*)|java\\.lang\\.Class(.*)", n, javaParserFacade);
    }
}
