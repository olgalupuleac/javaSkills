package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ControlFlowStatementSkill extends Skill {
    @Override
    public void visit(BreakStmt n, JavaParserFacade arg) {
        incrementScore(true);
    }

    @Override
    public void visit(ContinueStmt n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    /*@Override
    public void visit(ReturnStmt n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }*/

    @Override
    public void visit(SwitchStmt n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }
/*
    @Override
    public void visit(WhileStmt n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(IfStmt n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(ForStmt n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }*/

    @Override
    public String toString() {
        return "CONTROL_FLOW_STATEMENT";
    }
}
