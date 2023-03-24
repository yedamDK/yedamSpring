package com.yedam.spring.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.user.service.UserListVO;
import com.yedam.spring.user.service.UserVO;

//부메랑 테스트 용
@CrossOrigin
// 데이터를 반환하는 컨트롤러  RestController
@RestController
//기존의 @controller + @ResponseBody를 의미
//그래서 해당클래스 내 모든 컨트롤러는 객체를 반환(그래서 @ResponseBody를 생략할 수 있다.)
//그래서 모든 메소드는 페이지를 리턴하지 못한다.
public class UserRestController {

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public UserVO insertUser(UserVO userVO) {

		System.out.println("name : " + userVO.getName());
		System.out.println("age : " + userVO.getAge());

		return userVO;
	}

	@RequestMapping("/insertUsers")
	public List<UserVO> insertUserList(UserListVO userListVO) {

		for (UserVO user : userListVO.getList()) {
			System.out.println(user);
		}

		return userListVO.getList();
	}

	@RequestMapping("/getUserData")
	public UserVO getUserData(@RequestParam("id") String name, @RequestParam(defaultValue = "0", required = false) int age) {
		UserVO userVO = new UserVO();
		userVO.setName(name);
		userVO.setAge(age);

		return userVO;
	}

	@GetMapping("/getDataList")
	public String getDataList(@RequestParam(required = false) Map<String, Object> map) {
		String message = null;
		if (map.isEmpty()) {
			message = "데이터가 존재하지 않습니다.";
		}else {
			message = "데이터가 생성되었습니다.";
			
			Set<Map.Entry<String,Object>> entryList = map.entrySet();
			for(Map.Entry<String, Object> entry : entryList) {
				System.out.print("Key : " + entry.getKey() );
				System.out.println(", Value : " + entry.getValue());
			}
		}
		
		return message;
	}
	
	@RequestMapping("/getNames")
	public Map<String, Object> getNames(@RequestParam List<String> name){
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", name);
		
		return map;
	};
	
	@RequestMapping("/getEmpInfo/{employeeId}")
	public UserVO getEmpInfo(@PathVariable String employeeId) {
		UserVO userVO = new UserVO();
		userVO.setName(employeeId);
		return userVO;
	}
	
	@RequestMapping("/getInfo")
	public UserVO getInfo(@RequestBody UserVO userVO) {		
		return userVO;
	}
	
	@PostMapping("/upload")
	public String uploadFile(UserVO userVO) {
		System.out.println("name : " + userVO.getName());
		System.out.println("file : " + userVO.getPic().getOriginalFilename());
		return "업로드를 완료했습니다.";
	}

}
