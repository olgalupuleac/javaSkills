package ru.hse.lupuleac;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class GenericsSkill extends Skill {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        incrementScore(javaParserFacade.getTypeDeclaration(n).isGeneric());
    }

    @Override
    public void visit(MethodDeclaration n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        incrementScore(n.isGeneric());
    }

    @Override
    public String toString() {
        return "GENERICS";
    }
}
