package cn.tedu.api;

//import ApiConst;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 统一的执行完毕后的返回对象
 *
 * @author pandong
 * @date 2019年11月19日 下午14:48:09
 * @copyright(c) kiegame.com
 */
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -1;
    private long code;
    private String message;
    private List<T> data;
    private long total;

    public ApiResponse() {

    }

    public ApiResponse(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(long code, String message, List data, long total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getLength() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 判断是否成功
     *
     * @return
     */
    public Boolean isSuccess() {
        return ApiConst.Code.CODE_SUCCESS.code() == this.code;
    }

    /**
     * 构建成功提示返回对象
     *
     * @param message
     * @return
     */
    public static <T> ApiResponse<T> buildSuccessMessage(String message) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiConst.Code.CODE_SUCCESS.code());
        apiResponse.setMessage(message);
        return apiResponse;
    }

    /**
     * 构建错误提示返回对象
     *
     * @param message
     * @return
     */
    public static <T> ApiResponse<T> buildErrorMessage(String message) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiConst.Code.CODE_COMMON_ERROR.code());
        apiResponse.setMessage(message);
        return apiResponse;
    }

    /**
     * 熔断错误提示返回对象
     *
     * @param message
     * @return
     */
    public static <T> ApiResponse<T> buildHystrixErrorMessage(String message) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiConst.Code.CODE_HYSTRIX_ERROR.code());
        apiResponse.setMessage(message);
        return apiResponse;
    }

    /**
     * 构建未查询到返回
     *
     * @param message
     * @return
     */
    public static <T> ApiResponse<T> buildNoFindMessage(String message) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiConst.Code.CODE_NO_FIND.code());
        apiResponse.setMessage(message);
        return apiResponse;
    }

    /**
     * 构建成功返回数据对象(分页)
     *
     * @param obj
     * @return
     */
    public static <T> ApiResponse<T> buildSuccessResponse(long total, Object obj) {
        ApiResponse apiResponse = buildSuccessResponse(obj);
        apiResponse.setTotal(total);
        return apiResponse;
    }

    /**
     * 构建成功返回数据对象
     *
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> ApiResponse<T> buildSuccessResponse(Object obj) {
        List respList;

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiConst.Code.CODE_SUCCESS.code());
        apiResponse.setMessage("success");
        if (obj == null) {
            return apiResponse;
        }
        if (obj instanceof List) {
            respList = (List) obj;
        } else {
            respList = new ArrayList();
            if (!Objects.isNull(obj)) {
                respList.add(obj);
            }
        }
        apiResponse.setData(respList);
        return apiResponse;
    }


    /**
     * 将当前对象转换为json
     *
     * @return
     */
    public String asJSON() {
        return "";
    }

    @Override
    public String toString() {
        String resultMsg = "CODE:[" + code + "],MESSAGE:[" + message + "]";
        if (data != null) {
            resultMsg += ",DATA:[LIST TOTAL=" + total + " LEN=" + getLength() + "]";
        }
        return resultMsg;
    }
}
