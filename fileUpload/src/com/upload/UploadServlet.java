package com.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {

    //设置文件路径
    private String filepath = "E:/fielupload/";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1创建DiskFileItemFactory对象，配置缓存信息
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //2创建ServletFileUpload
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //3设置文件编码
        servletFileUpload.setHeaderEncoding("utf-8");
        //4解析文件
        try {
            List<FileItem> items = servletFileUpload.parseRequest(request);
            //5获取文件信息
            for (FileItem item:items){
                //6判断文件
                if(item.isFormField()){
                    //普通数据
                    String fileName = item.getFieldName();
                    if(fileName.equals("info")){
                        String info = item.getString("utf-8");
                        System.out.println(info);
                    }
                }else{
                    //文件
                    //获取文件名称
                    String name = item.getName();
                    if(!"".equals(name) && name != null){
                        InputStream is = item.getInputStream();
                        //保存文件
                        FileUtils.copyInputStreamToFile(is,new File(filepath+"/"+name));
                    }

                }
            }
        }catch (FileUploadException e){
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
