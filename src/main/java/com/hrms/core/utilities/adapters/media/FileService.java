package com.hrms.core.utilities.adapters.media;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    /**
     * Uploads file using file's name field.
     *
     * @param file           File to upload.
     *
     * @return               SourceUrl of saved file if successful as {@link DataResult} or,
     * <p>
     *                       Empty string and error message on error as {@link DataResult}
     */
    DataResult<String> uploadFile(File file);

    /**
     * Uploads file to given path.
     *
     * @param file           File to upload.
     * @param path           Path that can include root and filename. Must contain fileName and extension in it, root is optional.
     * @return               SourceUrl of saved file if successful as {@link DataResult} or,
     * <p>
     *                       Empty string and error message on error as {@link DataResult}
     */
    DataResult<String> uploadFile(File file, String path);

    /**
     * Uploads file using multipartFile's originalFileName field.
     *
     * @param multipartFile  File to upload.
     *
     * @return               SourceUrl of saved file if successful as {@link DataResult} or,
     * <p>
     *                       Empty string and error message on error as {@link DataResult}
     */
    DataResult<String> uploadFile(MultipartFile multipartFile);

    /**
     * Uploads file to given path.
     *
     * @param multipartFile  File to upload.
     * @param path           Path that can include root and filename. Must contain fileName and extension in it, root is optional.
     * @return               SourceUrl of saved file if successful as {@link DataResult} or,
     * <p>
     *                       Empty string and error message on error as {@link DataResult}
     */
    DataResult<String> uploadFile(MultipartFile multipartFile, String path);

    /**
     * Deletes the file in the given path.
     *
     * @param path           File path to delete
     * @return               Success and message as {@link Result}
     */
    Result delete(String path);

}
