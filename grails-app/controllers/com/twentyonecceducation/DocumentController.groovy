package com.twentyonecceducation

import com.twentyonecceducation.dam.DocumentService
import com.twentyonecceducation.security.SecRole
import com.twentyonecceducation.security.SecUser
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.web.multipart.MultipartFile


@Secured([SecRole.ROLE_USER])
class DocumentController {

    DocumentService documentService

    def springSecurityService
//    String searchText
    def index(String searchText) {
//        redirect(action: "list", params: params)
//        println(params)
        if (searchText==null){
            [document: Document.list(params)]
        }else {
            def docs = Document.where {name =~"%${searchText}%"}.list()
            println("There found ${docs.size()}")
            [documents: docs,document:Document.list()]
        }

    }
    def list() {
        params.max = 10
        [documentInstanceList: Document.list(params), documentInstanceTotal: Document.count()]
    }
    def create() {
    }
    def upload() {
        def mpf = request.getFile('docToUpload')
        if(mpf && !mpf.empty && mpf.size < 100024) {
            SecUser user = springSecurityService.currentUser
            println "We have file ${mpf.originalFilename} with size ${mpf.size}"
            Document.withTransaction {
                Document doc = new Document(name: mpf.originalFilename,
                        uploadedOn: new Date(),
                        uploadedBy: user,
                        filePath: 'tempFilePath').save(failOnError: true)
            }
        }
        redirect action : 'index'
    }
}