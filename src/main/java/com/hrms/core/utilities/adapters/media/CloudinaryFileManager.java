package com.hrms.core.utilities.adapters.media;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hrms.core.utilities.FileUtils;
import com.hrms.core.utilities.constants.CoreMessages;
import com.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
       return uploadFile(file, file.getName());
    }

    @Override
    public DataResult<String> uploadFile(File file, String path){
        String pathWithoutExtension = FileUtils.getPathWithoutFileExtension(path);
        try {
            cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", pathWithoutExtension));
        }
        catch (IOException e){
            return new ErrorDataResult<>("", CoreMessages.FILE_UPLOAD_ERROR);
        }
        return new SuccessDataResult<>(hostURL, CoreMessages.FILE_UPLOADED);

    }

    @Override
    public DataResult<String> uploadFile(MultipartFile multipartFile) {
        return uploadFile(multipartFile, multipartFile.getOriginalFilename());
    }

    @Override
    public DataResult<String> uploadFile(MultipartFile multipartFile, String path) {
        var fileConversionResult = FileUtils.multipartFileToFile(multipartFile);
        if(!fileConversionResult.isSuccess()){
            return new ErrorDataResult<>("", CoreMessages.FILE_TRANSFORMATION_ERROR);
        }

        DataResult<String> result = uploadFile(fileConversionResult.getData(), path);
        fileConversionResult.getData().delete();
        return result;
    }

    @Override
    public Result delete(String path) {
        String pathWithoutExtension = FileUtils.getPathWithoutFileExtension(path);
        try {
            cloudinary.uploader().destroy(pathWithoutExtension, ObjectUtils.emptyMap());
        }
        catch (IOException e){
            return new ErrorResult(CoreMessages.FILE_DELETE_ERROR);
        }
        return new SuccessResult(CoreMessages.FILE_DELETED);

    }
}
