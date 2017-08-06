package hotdog.commons.pagination;

import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

public class ImagePaginationRenderer extends AbstractPaginationRenderer {

	public ImagePaginationRenderer() {
		firstPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">[처음]</a>&#160;";
		previousPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">[이전]</a>&#160;";
		currentPageLabel = "<a href=\"#\" class=\"active\">{0}</a>&#160;";
		otherPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">{2}</a>&#160;";
		nextPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">[다음]</a>&#160;";
		lastPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">[마지막]</a>&#160;";
	}

	@Override
	public String renderPagination(PaginationInfo paginationInfo, String jsFunction) {

		return super.renderPagination(paginationInfo, jsFunction);
	}
}
