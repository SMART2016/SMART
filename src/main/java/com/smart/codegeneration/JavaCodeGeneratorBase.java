package com.smart.codegeneration;

import com.smart.log.LogFactory;
import com.smart.log.Logger;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPackage;

/**
 * Created by dipanjan on 02/04/16.
 */
public final class JavaCodeGeneratorBase {
    private static final Logger log = LogFactory.getLogger(JavaCodeGeneratorBase.class);
    private JCodeModel codeModel;

    private JavaCodeGeneratorBase() {

    }

    private static class Holder {
        private static final JavaCodeGeneratorBase INSTANCE = new JavaCodeGeneratorBase();
    }

    public static JavaCodeGeneratorBase getInstance() {
        return Holder.INSTANCE;
    }

    public void init() {
        this.codeModel = new JCodeModel();
    }

    public JCodeModel getNewCodeGenModel() {
        return new JCodeModel();
    }

    public JPackage createPackage(JCodeModel codeModel, String packageName) {
        return codeModel._package(packageName);
    }

    /**
     * If the class already exists in the same package this method will not create
     * another duplicate class and will simply return Null.
     *
     * @param packageForClass
     * @param className
     * @return new class created
     */
    public JDefinedClass createCLass(JPackage packageForClass, String className) {
        JDefinedClass Class = null;
        try {
            Class = packageForClass._class(className);
        } catch (JClassAlreadyExistsException e) {
            log.error(e.getMessage());
        }
        return Class;
    }
}
