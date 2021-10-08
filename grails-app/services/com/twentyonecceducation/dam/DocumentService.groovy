package com.twentyonecceducation.dam

import com.twentyonecceducation.Document
import com.twentyonecceducation.security.SecUser
import grails.gorm.transactions.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class DocumentService {

    Document uploadFile(MultipartFile fileToUpload, SecUser author) {

        String folderPath = "c:\\temp\\dam"
        File folder = new File(folderPath)
        if(!folder.exists()) {
            folder.mkdir()
        }
        String fileName = fileToUpload.originalFilename
        String fullPath = "${folderPath}/${fileName}"
        File destinationFile = new File(fullPath)
        fileToUpload.transferTo(destinationFile)

        Document doc = new Document( name: fileName,
                uploadedOn: new Date(),
                uploadedBy: author,
                filePath: fullPath).save(failOnError: true)

        return doc
    }
}
