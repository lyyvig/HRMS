package com.hrms.core.utilities.adapters.media;

import com.hrms.core.utilities.results.Result;

import java.io.File;
import java.io.IOException;

public interface FileService {
    Result uploadFile(File file);
    Result uploadFile(File file, String pathWithFileName);

}
