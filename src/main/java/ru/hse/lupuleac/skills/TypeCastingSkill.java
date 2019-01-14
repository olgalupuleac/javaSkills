package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.expr.CastExpr;
import com.github.javaparser.ast.expr.InstanceOfExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import ru.hse.lupuleac.skills.Skill;

public class TypeCastingSkill extends Skill {
    @Override
    public void visit(CastExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true, "cast");
    }

    @Override
    public void visit(InstanceOfExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true, "instanceOf");
    }

    @Override
    public String toString() {
        return "TYPE_CASTING";
    }
}
