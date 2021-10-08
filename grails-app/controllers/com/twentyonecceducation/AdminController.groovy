package com.twentyonecceducation

import com.twentyonecceducation.security.SecRole
import com.twentyonecceducation.security.SecUser
import grails.plugin.springsecurity.annotation.Secured

@Secured([SecRole.ROLE_ADMIN])
class AdminController {

    def index() {

        [userlist: SecUser.list(), rolelist:SecRole.list()]

    }


}
