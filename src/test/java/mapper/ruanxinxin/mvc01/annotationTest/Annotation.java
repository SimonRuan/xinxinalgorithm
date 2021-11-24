package mapper.ruanxinxin.mvc01.annotationTest;

import java.lang.annotation.*;

public class Annotation {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Table {
        String name() default "";
    }

    //
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Constraints {
        boolean primaryKey() default false;

        boolean allowNull() default true;

        boolean unique() default false;
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SQLString {
        int value() default 0;

        String name() default "";

        Constraints constraints() default @Constraints;
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SQLInteger {

        String name() default "";

        Constraints constraints() default @Constraints;
    }


}
