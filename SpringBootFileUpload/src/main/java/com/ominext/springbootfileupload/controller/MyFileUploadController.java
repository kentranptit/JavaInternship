package com.ominext.springbootfileupload.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ominext.springbootfileupload.form.MyUploadForm;

@Controller
public class MyFileUploadController {

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	// ----- Upload 1 file -----
	// GET: Hiển thị form Upload
	@RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
	public String uploadOneFileHandler(Model model) {
		model.addAttribute("myUploadForm", new MyUploadForm());
		return "uploadOneFile";
	}
	// POST: Xử lý Upload
	@RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
	public String uploadOneFileHandlerPOST(HttpServletRequest request, Model model,
			@ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
		return this.doUpload(request, model, myUploadForm);
	}

	// --- Upload nhiều file ---
	// GET: Hiển thị form Upload
	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.GET)
	public String uploadMultiFileHandler(Model model) {
		model.addAttribute("myUploadForm", new MyUploadForm());
		return "uploadMultiFile";
	}
	// POST: Xử lý Upload
	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
	public String uploadMultiFileHandlerPOST(HttpServletRequest request, Model model,
			@ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
		return this.doUpload(request, model, myUploadForm);
	}

	private String doUpload(HttpServletRequest request, Model model, MyUploadForm myUploadForm) {
		String description = myUploadForm.getDescription();
		System.out.println("Description: '" + description + "'");

		// Thư mục gốc upload file
		String uploadRootPath = request.getServletContext().getRealPath("upload");
		System.out.println("Upload root path = " + uploadRootPath);

		File uploadRootDirectory = new File(uploadRootPath);
		// Tạo thư mục gốc upload nếu nó không tồn tại
		if (!uploadRootDirectory.exists()) {
			uploadRootDirectory.mkdirs();
		}

		MultipartFile[] fileDatas = myUploadForm.getFileDatas();
		List<File> uploadedFiles = new ArrayList<File>();
		List<String> failedFiles = new ArrayList<String>();

		for (MultipartFile fileData : fileDatas) {
			// Tên file gốc tại Client
			String name = fileData.getOriginalFilename();
			System.out.println("Client's file Name: " + name);

			if (name != null && !name.isEmpty()) {
				try {
					// Tạo file tại Server
					File serverFile = new File(uploadRootDirectory.getAbsolutePath() + File.separator + name);
					
					BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(serverFile));
					outStream.write(fileData.getBytes());
					outStream.close();
					
					uploadedFiles.add(serverFile);
					System.out.println("Write File: " + serverFile);
				} catch (Exception e) {
					System.out.println("Error Write File: " + name);
					failedFiles.add(name);
				}
			}
		}
		model.addAttribute("description", description);
		model.addAttribute("uploadedFiles", uploadedFiles);
		model.addAttribute("failedFiles", failedFiles);
		return "uploadResult";
	}
	
}
