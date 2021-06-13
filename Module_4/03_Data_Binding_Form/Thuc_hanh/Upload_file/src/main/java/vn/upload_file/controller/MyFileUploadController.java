package vn.upload_file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import vn.upload_file.model.MyUploadForm;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyFileUploadController {
    // Phương thức này được gọi mỗi lần có Submit.
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
        if (target.getClass() == MyUploadForm.class) {
            // Đăng ký để chuyển đổi giữa các đối tượng multipart thành byte[]
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }

    // GET: Hiển thị trang form upload
    @GetMapping(value = "/uploadOneFile")
    public String uploadOneFileHandler(Model model) {
        model.addAttribute("myUploadForm", new MyUploadForm());
        return "uploadOneFile";
    }

    // POST: Xử lý Upload
    @PostMapping(value = "/uploadOneFile")
    public String uploadOneFileHandlerPOST(HttpServletRequest request, Model model,
                                           @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
        System.out.println(myUploadForm.getDescription());
//        System.out.println(myUploadForm.getFileDatas().getOriginalFilename());
//        return this.doUpload(request, model, myUploadForm);
        return "uploadResult";
    }

    // GET: Hiển thị trang form upload
    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.GET)
    public String uploadMultiFileHandler(Model model) {
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
        // Forward to "/WEB-INF/pages/uploadOneFile.jsp".
        return "uploadMultiFile";

    }

    // POST: Xử lý Upload

    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)

    public String uploadMultiFileHandlerPOST(HttpServletRequest request, Model model, @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {

        return this.doUpload(request, model, myUploadForm);

    }

    private String doUpload(HttpServletRequest request, Model model, MyUploadForm myUploadForm) {
//        String description = myUploadForm.getDescription();
//        System.out.println("Description: " + description);
//        // Thư mục gốc upload file.
//        String uploadRootPath = request.getServletContext().getRealPath("upload");
//        System.out.println("uploadRootPath=" + uploadRootPath);
//        File uploadRootDir = new File(uploadRootPath);
//        // Tạo thư mục gốc upload nếu nó không tồn tại.
//        if (!uploadRootDir.exists()) {
//            uploadRootDir.mkdirs();
//        }
//        MultipartFile[] fileDatas = myUploadForm.getFileDatas();
//        Map<File, String> uploadedFiles = new HashMap();
//        for (MultipartFile fileData : fileDatas) {
//            // Tên file gốc tại Client.
//            String name = fileData.getOriginalFilename();
//            System.out.println("Client File Name = " + name);
//            if (name != null && name.length() > 0) {
//                try {
//                    // Tạo file tại Server.
//                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
//                    // Luồng ghi dữ liệu vào file trên Server.
//                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//                    stream.write(fileData.getBytes());
//                    stream.close();
//                    uploadedFiles.put(serverFile, name);
//                    System.out.println("Write file: " + serverFile);
//                } catch (Exception e) {
//                    System.out.println("Error Write file: " + name);
//                }
//            }
//        }
//        model.addAttribute("description", description);
//        model.addAttribute("uploadedFiles", uploadedFiles);
        return "uploadResult";

    }
}
