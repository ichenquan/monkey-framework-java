package monkey.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class DbJoinSelectHelper {

    public static <T> Result<List<T>> selectList(DbLimitParameter parameter, DbJoinSelectListCommand selectListCommand) {
        Result<List<T>> result = new Result<>();
        try {
            List<T> data = selectListCommand.execute(parameter);
            result.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatusCode(50404);
            result.setMessage("查找失败");
        }
        return result;
    }

    public static <T> Result<PageInfo<T>> selectPage(DbPageParameter parameter, DbJoinSelectPageCommand selectPageCommand, DbJoinSelectCountCommand selectCountCommand) {
        if (parameter.getPageNum() < 1) {
            parameter.setPageNum(1);
        }

        if (parameter.getMaxSize() > 100) {
            parameter.setMaxSize(100);
        }

        parameter.setBeginIndex((parameter.getPageNum() - 1) * parameter.getPageSize());

        Result<PageInfo<T>> result = new Result<>();

        try {
            PageInfo<T> page = new PageInfo<>();
            List<T> list = selectPageCommand.execute(parameter);
            page.setList(list);
            page.setPageSize(parameter.getPageSize());
            page.setPageNum(parameter.getPageNum());

            if (selectCountCommand != null) {
                if (parameter.getTotal() == null || parameter.getTotal() == 0) {
                    Integer count = selectCountCommand.execute(parameter);
                    page.setTotal(count);
                    if (count > 0) {
                        Integer pages = count % page.getPageSize() == 0 ? count / page.getPageSize() : count / page.getPageSize() + 1;
                        page.setPages(pages);
                    }
                }
            }

            result.setData(page);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatusCode(50404);
            result.setMessage("查找失败");
        }

        return result;
    }
}
