package tech.qijin.study.arthas.agent;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import jdk.internal.org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.instrument.Instrumentation;
import java.util.List;

public class AgentBootstrap {
    private static PrintStream ps = System.err;
    public static void premain(String args, Instrumentation inst) {
        main(args, inst);
    }

    public static void agentmain(String args, Instrumentation inst) {
        main(args, inst);
    }

    public static void main(String args, Instrumentation inst) {
        ps.print("success");
        try {
            ClassReader classReader = new ClassReader("java.lang.String");
            ClassNode cn = new ClassNode();
            classReader.accept(cn, ClassReader.EXPAND_FRAMES);
            List<MethodNode> methods = cn.methods;
            ps.print("mmmm");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
