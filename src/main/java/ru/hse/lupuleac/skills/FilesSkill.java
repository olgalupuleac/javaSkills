package ru.hse.lupuleac.skills;

import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

import java.util.List;
import java.util.stream.Collectors;

public class FilesSkill extends Skill {
    @Override
    public String toString() {
        return "FILES";
    }

    @Override
    public void visit(MethodCallExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        matchMethodCall("java\\.io((?!print).)*", n, arg);
    }

    @Override
    public void visit(VariableDeclarationExpr n, JavaParserFacade arg) {
        super.visit(n, arg);
        List<ClassOrInterfaceType> types = n.getVariables().stream()
                .map(VariableDeclarator::getType).filter(Type::isClassOrInterfaceType)
                .map(Type::asClassOrInterfaceType)
                //.peek(System.out::println)
                .collect(Collectors.toList());
        //types.forEach(x -> System.out.println(arg.getTypeDeclaration(x).getQualifiedName()));
    }

    @Override
    public void visit(ObjectCreationExpr n, JavaParserFacade javaParserFacade) {
        super.visit(n, javaParserFacade);
        isSpecifiedObjectCreation("java.io.File", n, javaParserFacade);
    }
}
