package ru.hse.lupuleac;

import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

import javax.sound.sampled.EnumControl;

public class EnumSkill extends Skill {
    @Override
    public void visit(EnumDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public void visit(EnumConstantDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true);
    }

    @Override
    public String toString() {
        return "ENUM";
    }

}
