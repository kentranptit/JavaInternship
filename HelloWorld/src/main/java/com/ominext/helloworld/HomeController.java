package com.ominext.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController sẽ thông báo cho Spring biết phải TRẢ LẠI kết quả (in ra màn) về cho lời gọi
@RestController
public class HomeController {
	
	//RequestMapping báo cho Spring biết phải ánh xạ "/hello" url với method sayHello()
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
