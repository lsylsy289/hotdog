package hotdog.commons.upload.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("uploadDao")
public interface UploadDao {

    void insertUpload(Map<String, Object> paramMap);

    List<Map<String, Object>> selectUploadList(Map<String, Object> paramMap);

	void deleteUpload(Map<String, Object> paramMap);
}