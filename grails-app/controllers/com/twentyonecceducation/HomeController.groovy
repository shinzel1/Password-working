package com.twentyonecceducation

import com.twentyonecceducation.security.SecRole
import com.twentyonecceducation.security.SecUser
import grails.plugin.springsecurity.annotation.Secured

@Secured([SecRole.ROLE_USER, SecRole.ROLE_ADMIN])
class HomeController {

    def springSecurityService

    def index() {
        SecRole userRole = SecRole.findOrSaveByAuthority(SecRole.ROLE_USER)
        SecRole adminRole = SecRole.findOrSaveByAuthority(SecRole.ROLE_ADMIN)
        SecUser user = springSecurityService.currentUser
        if(user.authorities.contains(adminRole)) {
            redirect controller: 'admin'
        } else if(user.authorities.contains(userRole)) {
            redirect controller: 'document'
        } else {
            log.error("This should not happen")
        }
    }
}
