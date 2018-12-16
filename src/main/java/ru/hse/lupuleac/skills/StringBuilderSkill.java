package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import ru.hse.lupuleac.skills.Skill;

public class StringBuilderSkill extends Skill {
    @Override
    public String toString() {
        return "STRING_BUILDER";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        matchMethodCall("java\\.lang\\.StringBuilder\\.(.*)", n, arg);
    }
}
