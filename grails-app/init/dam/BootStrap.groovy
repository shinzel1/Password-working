package dam

import com.twentyonecceducation.security.SecRole
import com.twentyonecceducation.security.SecUser
import com.twentyonecceducation.security.SecUserSecRole

class BootStrap {

    def init = { servletContext ->

        SecRole.withTransaction {
            SecRole userRole = SecRole.findOrSaveByAuthority(SecRole.ROLE_USER)
            SecRole adminRole = SecRole.findOrSaveByAuthority(SecRole.ROLE_ADMIN)

            SecUser ernstUser = SecUser.findByEmail('ernst@geckotech.nl') ?: new SecUser(
                    email: 'ernst@geckotech.nl',
                    password: 'password',
                    enabled: true
            ).save(failOnError: true)
            if (!ernstUser.authorities.contains(userRole)) {
                SecUserSecRole.create ernstUser, userRole
            }
            SecUser abhishekUser = SecUser.findByEmail('abhishek.agrawal@21cceducation.com') ?: new SecUser(
                    email: 'abhishek.agrawal@21cceducation.com',
                    password: 'password12',
                    enabled: true
            ).save(failOnError: true)
            if (!abhishekUser.authorities.contains(userRole)) {
                SecUserSecRole.create abhishekUser, userRole
            }
            SecUser shivamUser = SecUser.findByEmail('shivam.verma@21cceducation.com') ?: new SecUser(
                    email: 'shivam.verma@21cceducation.com',
                    password: '21cceducation',
                    enabled: true
            ).save(failOnError: true)

            if (!shivamUser.authorities.contains(userRole)){
                SecUserSecRole.create shivamUser, userRole
            }

            SecUser NewUser = SecUser.findByEmail('newuser@gmail.com') ?: new SecUser(
                    email: 'newuser@gmail.com',
                    password: 'sachin123@',
                    enabled: true,
//                    enabled: false,
            ).save(failOnError: true)

            if (!NewUser.authorities.contains(userRole)) {
                SecUserSecRole.create NewUser, userRole
            }

            SecUser sacUser = SecUser.findByEmail('s@gmail.com') ?: new SecUser(
                    email: 's@gmail.com',
                    password: 'p',
                    enabled: true
            ).save(failOnError: true)

            if (!sacUser.authorities.contains(userRole)) {
                SecUserSecRole.create sacUser, userRole
            }
//            SecUser sachinUser = SecUser.findByEmail('sachin.vinay@21cceducation.com') ?: new SecUser(
//                    email: 'sachin.vinay@21cceducation.com',
//                    password: 'password',
//                    enabled: true
//            ).save(failOnError: true)
//
//            if (!sachinUser.authorities.contains(userRole)) {
//                SecUserSecRole.create sacUser, userRole
//            }
            SecUser sachinUser = SecUser.findByEmail('sachinvinay2017@gmail.com') ?: new SecUser(
                    email: 'sachinvinay2017@gmail.com',
                    password: 'password',
                    enabled: true
            ).save(failOnError: true)

            if (!sachinUser.authorities.contains(userRole)) {
                SecUserSecRole.create sachinUser, userRole
            }

            SecUser admin = SecUser.findByEmail('admin@geckotech.nl') ?: new SecUser(
                    email: 'admin@geckotech.nl',
                    password: 'p',
                    enabled: true
            ).save(failOnError: true)

            if (!admin.authorities.contains(adminRole)) {
                SecUserSecRole.create admin, adminRole
            }



        }
    }

    def destroy = {
    }
}
