package ru.hse.lupuleac;


import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public abstract class Skill extends VoidVisitorAdapter<JavaParserFacade> {
    protected int score;
    public int getScore() {
        return score;
    }

    protected void incrementScore(boolean isIncremented) {
        if(isIncremented) {
            score++;
        }
    }
}
