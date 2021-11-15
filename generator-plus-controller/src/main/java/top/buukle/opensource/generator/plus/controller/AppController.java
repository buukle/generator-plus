package top.buukle.opensource.generator.plus.controller;


import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.utils.StringUtil;
import top.buukle.opensource.generator.plus.utils.SystemUtil;
import top.buukle.opensource.generator.plus.service.constants.SystemConstants;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/app")
@Api(value = "App",tags=" App Controller")
public class AppController {

    @ResponseBody
    @RequestMapping ( "upload" )
    public CommonResponse<String> upload(@RequestParam( "file" ) MultipartFile file)  throws IOException {
        String storeDir = SystemUtil.getStoreDir();
        String genBatchUuid = UUID.randomUUID().toString().replace( StringUtil.MIDDLE, StringUtil.EMPTY);
        String serverPath = storeDir + StringUtil.BACKSLASH + genBatchUuid + StringUtil.BACKSLASH + file.getOriginalFilename();
        File file1 = new File(serverPath);
        file1.mkdirs();
        file.transferTo(file1);
        String downloadUri = serverPath.replaceFirst(SystemUtil.getStoreDir(), SystemConstants.SOFT_CONTEXT_PATH + "upload/temp");
        return new CommonResponse.Builder().buildSuccess(downloadUri);
    }
}
