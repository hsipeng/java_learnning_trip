package controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	//实现页面跳转
	@RequestMapping(value="/toFile.action")
	public String toFile(){
		return "file";
	}
	@RequestMapping(value="/updateFile.action")
	public String updateFile(Model model,MultipartFile file) throws IOException{
		String msg= "上传成功";
		
		FileUtils.writeByteArrayToFile(new File("D:\\project\\SpringMVC-Day01-1\\WebContent\\WEB-INF\\upload\\"+file.getOriginalFilename()),file.getBytes());
		model.addAttribute("msg",msg);
		
		return "hello";
	}
}
