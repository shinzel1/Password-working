package com.twentyonecceducation.dam

import com.twentyonecceducation.UserProfile
import com.twentyonecceducation.security.SecRole
import com.twentyonecceducation.security.SecUser
import com.twentyonecceducation.security.SecUserSecRole
import grails.gorm.transactions.Transactional
import grails.web.mapping.LinkGenerator

@Transactional
class MailingService {
    def mailService
    LinkGenerator grailsLinkGenerator
    def serviceMethod() {

    }
    def resetPasswordWithVerificationCode(SecUser user) {
        if(user) {
            user.accountVerificationCode = UUID.randomUUID()
            user.accountResetDate = new Date()
            user.save(failOnError:true)
            String resetLink = grailsLinkGenerator.link(controller:'user', action:'resetpassword',id:user.accountVerificationCode, absolute:'true')
            sendPasswordResetMail(user, resetLink)
        }
    }
    def sendPasswordResetMail(SecUser user, String resetLink) {
        try {
            UserProfile profile = UserProfile.findByUser(user)
            log.info("Sending resetLink ${resetLink} to ${user.email}")
            mailService.sendMail {
                to user.email
                subject "Please reset your 21CC password using Token"
                html view :"/mail/resetmail", model: [resetLink: resetLink, firstName: profile?.firstName, user:user]
            }
        }
        catch(Throwable t) {
            log.error("Unable to send email: ${t.message}")
        }
    }

    SecUser setPassword(String token, String pwd1) {
        SecUser user = SecUser.findByAccountVerificationCode(token)
        if(user) {
            SecUser.withTransaction {
                user.password = pwd1
                user.enabled = true
                if(!user.accountVerificationDate) {
                    user.accountVerificationDate = new Date()
                }
                user.accountVerificationCode = null
                user.accountResetDate = null
                user.save(failOnError:true, flush: true)
            }
        }

        return user
    }
}
