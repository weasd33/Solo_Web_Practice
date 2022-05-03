package spms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애노테이션 유지 정책
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String value() default "";
}
