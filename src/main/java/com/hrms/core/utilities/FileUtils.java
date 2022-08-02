package com.hrms.core.utilities;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

    /**
     * Creates a temporary file on java temp location and writes data on it.
     * <p>
     * Please don't forget to delete file after using it.
     *
     *
     * @return      Temp file created on java temp location as {@link DataResult} or,
     * <p>
     *              null and exception message as {@link DataResult}
     */
    public static DataResult<File> multipartFileToFile(MultipartFile multipartFile){
        File file = new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID() + multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(file);
        }
        catch (IOException e){
            file.delete();
            return new ErrorDataResult<>(null, e.getMessage());
        }
        return new SuccessDataResult<>(file);
    }

    /**
     * Replaces the substring that is after last "." character.
     *
     * @param path  Any path, it can include root in it.
     * @return      Returns the path without file extension.
     */
    public static String getPathWithoutFileExtension(String path){
        return path.replaceFirst("[.][^.]+$", "");
    }

    /**
     * @param fileName  Name of the file that can include "." inside it.
     * @return          Returns the file extension or null if no extension found in the filename.
     */
    public static String getFileExtension(String fileName){
        Pattern pattern = Pattern.compile("[.][^.]+$");
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()){
            return matcher.group().substring(1);
        }
        return null;
    }

}
