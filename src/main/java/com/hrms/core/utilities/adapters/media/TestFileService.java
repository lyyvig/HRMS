package com.hrms.core.utilities.adapters.media;

import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;

import java.io.File;
import java.io.IOException;

public class TestFileService implements FileService{

    @Override
    public Result uploadFile(File file) {
        return new SuccessResult("File uploaded");
    }

    @Override
    public Result uploadFile(File file, String path) {
        return new SuccessResult("File uploaded");
    }
}
