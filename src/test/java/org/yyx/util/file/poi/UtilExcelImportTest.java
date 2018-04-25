package org.yyx.util.file.poi;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yyx.entity.EntityBase;
import org.yyx.entity.ImportEmployee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public class UtilExcelImportTest {

    /**
     * UtilExcelImportTest 日志控制器
     * Create by 叶云轩 at 2018/4/24 下午6:26
     * Concat at tdg_yyx@foxmail.com
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtilExcelImportTest.class);

    @Test
    public void importExcel() throws FileNotFoundException {
        File file = new File("/Users/hart-xuan/Desktop/人资部导入模版.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        long startTime = System.currentTimeMillis();
        UtilExcelImport.importExcel(inputStream, false);
        long endTime = System.currentTimeMillis();
        LOGGER.info("\n\t------------------------------------------\n" +
                "\t| [导入耗时]: {}毫秒\n" +
                "\t------------------------------------------", endTime - startTime);
    }

    @Test
    public void importExcelIntoEntity() {
        URL resource = this.getClass().getClassLoader().getResource("test.xlsx");
        String path = resource.getPath();
        File file = new File(path);
        try {
            Object[] objects = UtilExcelImport.importExcelIntoEntity(file, new Class[]{ImportEmployee.class});
            for (Object object : objects) {
                List<ImportEmployee> o = (List<ImportEmployee>) object;
                for (ImportEmployee importEmployee : o) {

                LOGGER.info("\n\t⌜⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓\n" +
                        "\t├ [obje]: {}\n" +
                        "\t⌞⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓", importEmployee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void importExcelXls() {

    }

    @Test
    public void importExcelXlsx() {
//        File file = new File("/Users/hart-xuan/Desktop/花名册模板-new.xlsx");
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        List<Object> objects;
//        objects = UtilExcelImport.importExcelXlsx(fileInputStream, ImportEmployee.class);
//        for (Object object : objects) {
//            System.out.println(object);
//        }
    }
}