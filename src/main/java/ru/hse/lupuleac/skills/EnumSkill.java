package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class EnumSkill extends Skill {
    @Override
    public void visit(EnumDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true, "declaration");
    }

    @Override
    public void visit(EnumConstantDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        incrementScore(true, "constant_declaration");
    }

    @Override
    public String toString() {
        return "ENUM";
    }

}
