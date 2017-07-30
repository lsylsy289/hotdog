package hotdog.commons.upload.svc.impl;

import hotdog.commons.upload.dao.UploadDao;
import hotdog.commons.upload.svc.UploadService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("uploadService")
public class UploadServiceImpl implements UploadService{

    @Resource(name = "uploadDao")
    private UploadDao uploadDao;

    @Override
    public void uploadSave(Map<String, Object> paramMap) {

    	uploadDao.insertUpload(paramMap);
    }

    @Override
    public List<Map<String, Object>> selectUploadList(Map<String, Object> paramMap) {
        return uploadDao.selectUploadList(paramMap);
    }

	@Override
	public void deleteUpload(Map<String, Object> paramMap) {
		
		uploadDao.deleteUpload(paramMap);
	}

}
