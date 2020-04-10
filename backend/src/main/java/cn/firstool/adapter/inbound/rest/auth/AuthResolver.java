package cn.thoughtworks.school.adapter.inbound.rest.auth;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AuthResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(Auth.class) != null;
    }

    @Override
    public User resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String username = webRequest.getHeader("username");
        String roleStr = webRequest.getHeader("roles");
        String id = webRequest.getHeader("id");
        User current = new User();
        if (roleStr == null || "".equals(roleStr)) {
            roleStr = "0";
        }

        List<Integer> roles = Arrays.stream(roleStr.split(","))
            .map(Integer::valueOf)
            .collect(Collectors.toList());
        current.setUsername(username);
        current.setRoles(roles);
        if (id != null) {
            current.setId(Long.valueOf(id));
        }
        return current;
    }

    public static class User {
        private String username;
        private List<Integer> roles;
        private Long id;

        public User() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<Integer> getRoles() {
            return roles;
        }

        public void setRoles(List<Integer> roles) {
            this.roles = roles;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
