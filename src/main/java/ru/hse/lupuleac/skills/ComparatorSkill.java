package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class ComparatorSkill extends Skill {
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade arg) {
    }

    @Override
    public String toString() {
        return "COMPARATOR";
    }
}
