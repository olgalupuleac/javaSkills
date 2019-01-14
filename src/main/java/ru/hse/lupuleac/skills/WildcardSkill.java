package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.type.WildcardType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import ru.hse.lupuleac.skills.Skill;

public class WildcardSkill extends Skill {
    @Override
    public void visit(WildcardType n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true, "wildcard");
    }

    @Override
    public String toString() {
        return "WILDCARDS";
    }
}
