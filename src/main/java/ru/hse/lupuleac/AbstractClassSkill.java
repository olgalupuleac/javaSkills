package ru.hse.lupuleac;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;


//TODO name starts with abstract
public class AbstractClassSkill extends Skill {
    @Override
    public void visit(MethodDeclaration c, JavaParserFacade arg) {
        super.visit(c, arg);
        incrementScore(c.isAbstract());
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration c, JavaParserFacade arg) {
        super.visit(c, arg);
        incrementScore(c.isAbstract());
    }

    @Override
    public String toString() {
        return "ABSTRACT_CLASS";
    }
}
