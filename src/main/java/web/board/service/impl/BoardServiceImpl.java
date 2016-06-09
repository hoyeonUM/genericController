package web.board.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import web.board.service.BoardService;
import web.board.service.BoardVO;
import web.common.service.impl.AbstractDAO;

@Repository("BoardService")
public class BoardServiceImpl extends AbstractDAO implements BoardService{

	@Override
	public Object save(Object entity) {
		// TODO Auto-generated method stub
		return "1";
	}

	@Override
	public Object findOne(Serializable primaryKey) {
		// TODO Auto-generated method stub
		return selectByPk("Board.selectBoard", primaryKey);
	}

	@Override
	public Iterable<BoardVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Serializable primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

}
