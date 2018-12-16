package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import ru.hse.lupuleac.skills.Skill;

public class StreamsSkill extends Skill {
    public String toString() {
        return "STREAMS";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        matchMethodCall("java\\.util\\.stream\\.(.*)", n, javaParserFacade);
    }
}
