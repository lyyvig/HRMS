package com.hrms.core.utilities.adapters.media;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;

import java.io.File;

public interface FileService {
    DataResult<String> uploadFile(File file);
    DataResult<String> uploadFile(File file, String pathWithFileName);
    Result delete(String path);

}
