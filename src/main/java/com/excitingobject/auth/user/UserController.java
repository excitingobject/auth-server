package com.excitingobject.auth.user;

import com.excitingobject.common.base.api.EoRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends EoRestController {

    @GetMapping
    public Object selectOne (@RequestParam String userId) throws Exception {
        return null;
    }

}
