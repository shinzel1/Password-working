package com.twentyonecceducation

import com.twentyonecceducation.dam.MailingService
import com.twentyonecceducation.dam.RegistrationService
import com.twentyonecceducation.security.SecRole
import com.twentyonecceducation.security.SecUser
import com.twentyonecceducation.security.SecUserSecRole
import grails.plugin.springsecurity.annotation.Secured
import java.util.UUID
@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class UserController {
    RegistrationService registrationService
    def springSecurityService
    def MailingService

    def index() {
        def adminRole = SecRole.findByAuthority(SecRole.ROLE_ADMIN)
        SecUserSecRole[] adminRoles = SecUserSecRole.findAllBySecRole(adminRole)
    }


    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def forgotPassword() {
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def passwordConfirmation() {
    }

    def invite(String username) {
        SecUser SUser = SecUser.findByEmail(username)
        MailingService.resetPasswordWithVerificationCode(SUser)
        redirect(action: 'passwordConfirmation')
    }
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def resetpassword() {
        String token = null
        String code = params.id == null ? params.token : params.id
        flash.message = null
        flash.error = null
        SecUser user = SecUser.findByAccountVerificationCode(code)
        log.debug("verify Job Seeker Account has been called for ${user} with code - ${code}")
        if (user) {
//            if (request.method.equals('POST')) {
                if (!params.pwd1 || !params.pwd2 || !params.pwd2.equals(params.pwd1)) {
                    flash.error = "Passwords should match exactly"
                    token = code
                } else {
                    user = MailingService.setPassword(params.token, params.pwd1)
                    token = null
                    redirect(controller:'login', action: 'auth')
                }

        }
            //so if token is not set, the user will not be able to set the password but see an error message.

        [token: token]
        }

    }

