package com.hrms.core.utilities.adapters.media;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hrms.core.utilities.constants.CoreMessages;
import com.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class CloudinaryFileManager implements FileService {
    private Cloudinary cloudinary;
    private String hostURL = "https://res.cloudinary.com/lyvig/image/upload/";

    @Autowired
    public CloudinaryFileManager(Environment ev) {
        this.cloudinary = new Cloudinary(ev.getProperty("CLOUDINARY_URL"));

    }

    @Override
    public DataResult<String> uploadFile(File file){
       return uploadFile(file, "images/" + file.getName());
    }

    @Override
    public DataResult<String> uploadFile(File file, String path){
        try {
            String pathWithoutExtension = path.replaceFirst("[.][^.]+$", "");
            cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", pathWithoutExtension));
            return new SuccessDataResult<>(hostURL, CoreMessages.FILE_UPLOADED);
        }
        catch (IOException e){
            return new ErrorDataResult<>("", CoreMessages.FILE_UPLOAD_ERROR);
        }

    }

    @Override
    public Result delete(String path) {
        try {
            String pathWithoutExtension = path.replaceFirst("[.][^.]+$", "");
            var a =cloudinary.uploader().destroy(pathWithoutExtension, ObjectUtils.emptyMap());
            return new SuccessResult(CoreMessages.FILE_DELETED);
        }
        catch (IOException e){
            return new ErrorResult(CoreMessages.FILE_DELETE_ERROR);
        }

    }
}
