package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

public class SerializationSkill extends Skill {
    @Override
    public String toString() {
        return "SERIALIZATION";
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, JavaParserFacade arg) {
        super.visit(n, arg);
        hasParent("java.io.Serializable", n, arg);
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        matchMethodCall("java\\.io\\.ObjectOutputStream\\.writeObject|java\\.io\\.ObjectInputStream\\.readObject", n, javaParserFacade);
    }
}
