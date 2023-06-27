package com.production.erp.ERPController;

import com.production.erp.model.FileModel;
import com.production.erp.service.CartService;
import com.production.erp.service.FileService;
import com.production.erp.view.CartView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class FileController {
    private final FileService fileService;
    private final CartService cartService;

    @Autowired
    public FileController(FileService fileService, CartService cartService) {
        this.fileService = fileService;
        this.cartService = cartService;
    }

    @PreAuthorize("hasRole('ROLE_SHOP')")
    @RequestMapping("/uploadForm/{order_number}")
    public String uploadFile(@PathVariable("order_number") Long order_number, Model model) {
        model.addAttribute("order_number", order_number);

        return "ERP/file/uploadForm";
    }

    @PreAuthorize("hasRole('ROLE_SHOP')")
    @RequestMapping(value = "/upload_file", method = RequestMethod.POST)
    public String submit(@RequestParam MultipartFile file, @RequestParam Long order_number, @RequestParam String format, ModelMap modelMap) throws IOException {
        modelMap.addAttribute("order_number", order_number);
        modelMap.addAttribute("file", file);

        FileModel fileModel = new FileModel();
        fileModel.setOrder_number(order_number);
        fileModel.setName(file.getOriginalFilename());
        fileModel.setType(file.getContentType());
        fileModel.setData(file.getBytes());
        fileModel.setFormat(format);
        fileService.uploadFile(fileModel);

        return "ERP/comment/created";
    }

    @PreAuthorize("hasRole('ROLE_SHOP')")
    @RequestMapping(value = "/upload_file_modal", method = RequestMethod.POST)
    public String submitModal(@RequestParam MultipartFile file, @RequestParam Long order_number, @RequestParam String format, ModelMap modelMap) throws IOException {
        modelMap.addAttribute("order_number", order_number);
        modelMap.addAttribute("file", file);

        FileModel fileModel = new FileModel();
        fileModel.setOrder_number(order_number);
        fileModel.setName(file.getOriginalFilename());
        fileModel.setType(file.getContentType());
        fileModel.setData(file.getBytes());
        fileModel.setFormat(format);
        fileService.uploadFile(fileModel);

        return "redirect:/purchased-details/" + order_number;
    }

    @PreAuthorize("hasRole('ROLE_SHOP')")
    @RequestMapping(value = "/upload_file_modal_NewPay", method = RequestMethod.POST)
    public String submitModalNewPay(@RequestParam MultipartFile file, @RequestParam Long order_number, @RequestParam String format, @RequestParam(name = "date", required = false) String date, ModelMap modelMap) throws IOException {
        List<CartView> cartViews = cartService.cartView();
        CartView listCart = new CartView(cartViews);
        modelMap.addAttribute("cartList", listCart);

        modelMap.addAttribute("order_number", order_number);
        modelMap.addAttribute("file", file);

        FileModel fileModel = new FileModel();
        fileModel.setOrder_number(order_number);
        fileModel.setName(file.getOriginalFilename());
        fileModel.setType(file.getContentType());
        fileModel.setData(file.getBytes());
        fileModel.setFormat(format);
        fileService.uploadFile(fileModel);

        return "redirect:/to_order/" + date;
    }

    @PreAuthorize("hasRole('ROLE_SHOP')")
    @RequestMapping("/files")
    public String files(Model model) {
        List<FileModel> files = fileService.listFiles();
        model.addAttribute("files", files);

        return "ERP/file/files";
    }

    @PreAuthorize("hasRole('ROLE_SHOP')")
    @RequestMapping("/download/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable("id") Long id) {
        FileModel fileDB = fileService.fileById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }

    @PreAuthorize("hasRole('ROLE_SHOP')")
    @RequestMapping("/delete/{id}/{order_number}")
    public String delete(@PathVariable Long id, @PathVariable Long order_number) {
        fileService.delete(id);
        return "redirect:/purchased-details/" + order_number;
    }
}
