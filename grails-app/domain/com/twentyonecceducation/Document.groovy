package com.twentyonecceducation

import com.twentyonecceducation.security.SecUser
class Document {

    String name
    Date uploadedOn
    SecUser uploadedBy
    String filePath
    List<Taggs> taggs
    static hasMany = [taggs: Taggs]
    static constraints = {
        name(blank:false,nullable:false)
        data(blank: true, nullable:true, maxSize:1073741824)
   }


}
