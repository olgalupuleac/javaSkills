package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class CodeStyleSkill extends Skill {
    @Override
    public String toString() {
        return "CODE_STYLE";
    }

    @Override
    public void visit(JavadocComment n, JavaParserFacade arg) {
        incrementScore(true, "j");
    }
    //TODO camel case
}
