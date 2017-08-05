package hotdog.commons.upload.svc;

import java.util.List;
import java.util.Map;

public interface UploadService {

    List<Map<String, Object>> selectUploadList(Map<String, Object> paramMap);

    void uploadSave(Map<String, Object> paramMap);

	void deleteUpload(Map<String, Object> paramMap);
}
