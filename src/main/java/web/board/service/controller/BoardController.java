package web.board.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import web.board.service.BoardVO;
import web.common.service.CrudRepository;
import web.common.web.RESTController;

@Controller
@RequestMapping("/board")
public class BoardController extends RESTController<BoardVO,String>{

	
	@Autowired
	public BoardController(CrudRepository<BoardVO, String> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
