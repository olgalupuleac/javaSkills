package ru.hse.lupuleac;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import ru.hse.lupuleac.skills.Skill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SkillCalculator {
    public static int getScore(Skill skill, String pathToFile, String pathToRoot) throws FileNotFoundException, ParseException {
        TypeSolver typeSolver = new CombinedTypeSolver(new ReflectionTypeSolver(), new JavaParserTypeSolver(new File(pathToRoot)));
        CompilationUnit agendaCu = JavaParser.parse(new FileInputStream(new File(pathToFile)));

        agendaCu.accept(skill, JavaParserFacade.get(typeSolver));
        return skill.getScore();
    }
}