package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ExceptionHandlingSkill extends Skill {

    @Override
    public void visit(CatchClause n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(n.getBody().getStatements().size() > 0);
    }

    @Override
    public String toString() {
        return "EXCEPTIONS_HANDLING";
    }
 }
