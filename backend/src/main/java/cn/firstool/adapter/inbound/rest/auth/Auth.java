package cn.thoughtworks.school.adapter.inbound.rest.auth;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface Auth {
}
