package ru.hse.lupuleac;

import com.github.javaparser.ast.stmt.ThrowStmt;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ExceptionsSkill extends Skill {
    @Override
    public void visit(ThrowStmt n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public String toString() {
        return "EXCEPTIONS";
    }

}
