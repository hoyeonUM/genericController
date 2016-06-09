package web.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class AbstractDAO extends SqlSessionDaoSupport{
    protected Log log = LogFactory.getLog(AbstractDAO.class);
     
     
    
    @Resource(name = "sqlSession")
    public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
    	super.setSqlSessionFactory(sqlSession);
    }



    
     
    /**
     * �Է� ó�� SQL mapping �� �����Ѵ�.
     *
     * @param queryId -  �Է� ó�� SQL mapping ���� ID
     * @param parameterObject - �Է� ó�� SQL mapping �Է� �����͸� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
     *
     * @return DBMS�� �����ϴ� ��� insert ���� ��� count
     */
    public int insert(String queryId, Object parameterObject) {
    	return getSqlSession().insert(queryId, parameterObject);
    }

    /**
     * ���� ó�� SQL mapping �� �����Ѵ�.
     *
     * @param queryId - ���� ó�� SQL mapping ���� ID
     * @param parameterObject - ���� ó�� SQL mapping �Է� ������(key ���� �� ���� ������)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
     *
     * @return DBMS�� �����ϴ� ��� update ���� ��� count
     */
    public int update(String queryId, Object parameterObject) {
        return getSqlSession().update(queryId, parameterObject);
    }

    /**
     * ���� ó�� SQL mapping �� �����Ѵ�.
     *
     * @param queryId - ���� ó�� SQL mapping ���� ID
     * @param parameterObject - ���� ó�� SQL mapping �Է� ������(�Ϲ������� key ����)��  ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
     *
     * @return DBMS�� �����ϴ� ��� delete ���� ��� count
     */
    public int delete(String queryId, Object parameterObject) {
        return getSqlSession().delete(queryId, parameterObject);
    }

    /**
     * pk �� �������� �� �ܰ���ȸ ó�� SQL mapping �� �����Ѵ�.
     *
     * @param queryId - �ܰ� ��ȸ ó�� SQL mapping ���� ID
     * @param parameterObject - �ܰ� ��ȸ ó�� SQL mapping �Է� ������(key)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
     *
     * @return ��� ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� ���� ��� ��ü(���� VO �Ǵ� Map)
     */
    public Object selectByPk(String queryId, Object parameterObject) {
        return getSqlSession().selectOne(queryId, parameterObject);
    }

    /**
     * ����Ʈ ��ȸ ó�� SQL mapping �� �����Ѵ�.
     *
     * @param queryId - ����Ʈ ��ȸ ó�� SQL mapping ���� ID
     * @param parameterObject - ����Ʈ ��ȸ ó�� SQL mapping �Է� ������(��ȸ ����)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
     *
     * @return ��� List ��ü - SQL mapping ���Ͽ��� ������  resultType/resultMap �� ���� ��� ��ü(���� VO   �Ǵ� Map)�� List
     */
	public List<?> list(String queryId, Object parameterObject) {
        return getSqlSession().selectList(queryId, parameterObject);
    }

    /**
     * �κ� ���� ����Ʈ ��ȸ ó�� SQL mapping �� �����Ѵ�.
     * (�κ� ���� - pageIndex �� pageSize ������� ���� �κ� ���� ��ȸ�� ���� skipResults, maxResults �� ����Ͽ� ibatis ȣ��)
     *
     * @param queryId - ����Ʈ ��ȸ ó�� SQL mapping ���� ID
     * @param parameterObject - ����Ʈ ��ȸ ó�� SQL mapping �Է� ������(��ȸ ����)�� ������ �Ķ���� ��ü(���� VO �Ǵ� Map)
     * @param pageIndex - ���� ������ ��ȣ
     * @param pageSize - �� ������ ��ȸ ��(pageSize)
     *
     * @return �κ� ���� ��� List ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� �κ� ���� ��� ��ü(���� VO �Ǵ� Map) List
     */
	public List<?> listWithPaging(String queryId, Object parameterObject, int pageIndex, int pageSize) {
        int skipResults = pageIndex * pageSize;
        //int maxResults = (pageIndex * pageSize) + pageSize;

        RowBounds rowBounds = new RowBounds(skipResults, pageSize);

        return getSqlSession().selectList(queryId, parameterObject, rowBounds);
    }

    /**
     * SQL ��ȸ ����� ResultHandler�� �̿��ؼ� ����Ѵ�.
     * ResultHandler�� ����� ������ Ŀ���� �ڵ鷯�� handleResult() �޼��忡 ���� ����ȴ�.
     *
     * @param queryId - ����Ʈ ��ȸ ó�� SQL mapping ���� ID
     * @param handler - ��ȸ ����� �����ϱ� ���� ������ ResultHandler
     * @return
     *
     * @return ��� List ��ü - SQL mapping ���Ͽ��� ������ resultType/resultMap �� ���� ��� ��ü(���� VO   �Ǵ� Map)�� List
     */
    public void  listToOutUsingResultHandler(String queryId, ResultHandler handler) {
		getSqlSession().select(queryId, handler);
    }
}
