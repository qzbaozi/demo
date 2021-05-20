package com.sfh;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class ResourceHelper {
    public static String getResourceAsString(Class aClass, String file) {

        String path1 = aClass.getProtectionDomain().getCodeSource().getLocation().getPath();

        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:"+file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return FileUtil.readString(jsonFile, CharsetUtil.CHARSET_UTF_8);
    }
}
