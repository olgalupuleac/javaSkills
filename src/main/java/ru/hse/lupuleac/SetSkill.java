package ru.hse.lupuleac;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class SetSkill extends Skill {
    @Override
    public void visit(MethodCallExpr m, JavaParserFacade javaParserFacade) {
        super.visit(m, javaParserFacade);
        incrementScore(
                javaParserFacade.solve(m).getCorrespondingDeclaration()
                        .getQualifiedName().matches("java\\.util\\.(.*)Set\\.(.*)"));
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration c, JavaParserFacade javaParserFacade) {
        super.visit(c, javaParserFacade);
        incrementScore(javaParserFacade.getTypeDeclaration(c).getAllAncestors().stream().
                map(ResolvedReferenceType::getQualifiedName).anyMatch(x -> x.equals("java.util.Set")));
    }

    @Override
    public String toString() {
        return "SET";
    }
}

