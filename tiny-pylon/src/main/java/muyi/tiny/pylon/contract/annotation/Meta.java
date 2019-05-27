package muyi.tiny.pylon.contract.annotation;

import java.lang.annotation.*;

/**
 * @author: Yang Fan
 * @date: 2019-05-24
 * @desc:
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = Metas.class)
@Target({ElementType.TYPE})
public @interface Meta {

    String key();

    Class<?> type();
}
