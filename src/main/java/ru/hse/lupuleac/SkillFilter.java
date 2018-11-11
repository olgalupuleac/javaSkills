package ru.hse.lupuleac;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class SkillFilter {
    private static Skill[] skills = {new AbstractClassSkill(), new AnnotationSkill(),
            new AnonymousClassSkill(), new ArraySkill(), new BitOperationsSkill(), new CollectionsSkill(),
            new CollectorsSkill(), new ConstructorSkill(), new ControlFlowStatementSkill(), new EnumSkill(),
            new ExceptionHandlingSkill(), new ExceptionsSkill(), new GenericsSkill(), new InheritanceSkill(),
            new InitializationBlockSkill(), new InterfaceSkill(), new LambdaSkill(), new ListSkill(),
            new LogicalOperationsSkill(), new MapSkill(), new MethodReferenceSkill(), new RegexSkill(), new SetSkill(),
            new StaticMembersSkill(), new TypeCastingSkill(), new WildcardSkill()};

    public static Map<String, Integer> getSkillsScore(String pathToFile, String pathToRoot) throws Exception {
            TypeSolver typeSolver = new CombinedTypeSolver(new ReflectionTypeSolver(), new JavaParserTypeSolver(new File(pathToRoot)));
            CompilationUnit agendaCu = JavaParser.parse(new FileInputStream(new File(pathToFile)));
            Map<String, Integer> result = new HashMap<>();
            for (Skill skill : skills) {
                agendaCu.accept(skill, JavaParserFacade.get(typeSolver));
                result.put(skill.toString() ,skill.getScore());
            }
            return result;
    }

    public static void main(String[] args) {
        try {
            Map<String, Integer> result = getSkillsScore(args[0], args[1]);
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
