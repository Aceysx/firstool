package cn.thoughtworks.school.adapter.inbound.rest.resources.user;

import cn.thoughtworks.school.adapter.outbound.gateway.user.UserCenterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserResource {

    private final UserCenterService userCenterService;

    public UserResource(UserCenterService userCenterService) {
        this.userCenterService = userCenterService;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getUserById(@PathVariable Long userId) {
        UserDto user = userCenterService.getUserInfo(userId);

        return ResponseEntity.ok(user);
    }

}
