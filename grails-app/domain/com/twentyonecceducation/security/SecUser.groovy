package com.twentyonecceducation.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='email')
@ToString(includes='email', includeNames=true, includePackage=false)
class SecUser implements Serializable {

    private static final long serialVersionUID = 1

    String email
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    String accountVerificationCode //this is used for both initial verification and password reset as they are essentially the same use case
    Date accountVerificationDate //initial activationDate
    Date accountResetDate //so that we can block old requests

    Set<SecRole> getAuthorities() {
        (SecUserSecRole.findAllBySecUser(this) as List<SecUserSecRole>)*.secRole as Set<SecRole>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        email nullable: false, blank: false, unique: true, email: true
        accountVerificationCode nullable: true
        accountVerificationDate nullable: true
        accountResetDate nullable: true
    }

    static mapping = {
	    password column: '`password`'
    }
}
