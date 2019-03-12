package com.example.spring02.controller.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.board.dto.ReplyDTO;
import com.example.spring02.service.board.ReplyService;

// @ResponseBody를 붙이지 않아도 뷰가 아닌 데이터 리턴 가능
@RestController // spring 4.0부터 사용 가능
@RequestMapping("reply/*") //공통적인 url pattern
public class ReplyController {

	@Inject
	ReplyService replyService;
	
	@RequestMapping("list.do")
	public ModelAndView list(int bno, ModelAndView mav) {
		List<ReplyDTO> list=replyService.list(bno); //댓글 목록
		mav.setViewName("board/reply_list"); //뷰의 이름
		mav.addObject("list", list); //뷰에 전달할 데이터 저장
		return mav; //뷰로 이동
	}
	//댓글 목록을 ArrayList로 리턴
	@RequestMapping("list_json.do")
	public List<ReplyDTO> list_json(int bno){
		return replyService.list(bno);
	}
	
	@RequestMapping("insert.do") //세부적인 url pattern
	public void insert(ReplyDTO dto, HttpSession session) {
		//댓글 작성자 아이디
		String userid=(String)session.getAttribute("userid");
		dto.setReplyer(userid);
		//댓글이 테이블에 저장됨
		replyService.create(dto);
		//jsp 페이지로 가거나 데이터를 리턴하지 않음
	}
}







