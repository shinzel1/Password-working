package com.twentyonecceducation

import com.twentyonecceducation.security.SecUser

class UserProfile {
    String firstName
    String lastName
    Date dateCreated
    static belongsTo = [user: SecUser]
    static constraints = {
        firstName nullable: true
        lastName nullable: true

        dateCreated nullable: true
    }
}
