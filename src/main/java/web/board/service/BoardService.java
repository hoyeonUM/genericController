package web.board.service;

import java.io.Serializable;

import web.common.service.CrudRepository;

public interface BoardService<T> extends CrudRepository<T, Serializable>{

}
