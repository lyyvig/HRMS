package com.hrms.core.utilities.adapters.media;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;

import java.io.File;

public class TestFileService implements FileService{

    @Override
    public DataResult<String> uploadFile(File file) {
        return new SuccessDataResult<>("","File uploaded");
    }

    @Override
    public DataResult<String> uploadFile(File file, String path) {
        return new SuccessDataResult<>("","File uploaded");
    }

    @Override
    public Result delete(String path) {
        return new SuccessResult("File deleted");
    }
}
