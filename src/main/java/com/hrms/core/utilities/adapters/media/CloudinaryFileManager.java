package com.hrms.core.utilities.adapters.media;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hrms.core.utilities.constants.CoreMessages;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CloudinaryFileManager implements FileService {
    Cloudinary cloudinary;

    @Autowired
    public CloudinaryFileManager(Environment ev) {
        this.cloudinary = new Cloudinary(ev.getProperty("CLOUDINARY_URL"));

    }

    @Override
    public Result uploadFile(File file){
       return uploadFile(file, file.getName());
    }

    @Override
    public Result uploadFile(File file, String path){
        try {
            String pathWithoutExtension = path.replaceFirst("[.][^.]+$", "");
            cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", pathWithoutExtension));
            return new SuccessResult(CoreMessages.FILE_UPLOADED);
        }
        catch (IOException e){
            return new ErrorResult(CoreMessages.FILE_UPLOAD_ERROR);
        }

    }
}
