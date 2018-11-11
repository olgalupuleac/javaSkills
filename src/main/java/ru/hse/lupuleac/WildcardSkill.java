package ru.hse.lupuleac;

import com.github.javaparser.ast.type.WildcardType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class WildcardSkill extends Skill {
    @Override
    public void visit(WildcardType n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public String toString() {
        return "WILDCARDS";
    }
}
