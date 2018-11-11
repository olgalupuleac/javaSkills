package ru.hse.lupuleac;

import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ExceptionHandlingSkill extends Skill {

    @Override
    public void visit(CatchClause n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public String toString() {
        return "EXCEPTIONS_HANDLING";
    }
 }
