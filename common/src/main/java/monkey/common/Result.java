package monkey.common;

public class Result<T> {

    private String serviceCode;

    private String methodCode;

    private int statusCode = StatusCode.SUCCESS;

    private String message;

    private T data;    // 请求结果

    public Result(String serviceCode, String methodCode, int statusCode, T data) {
        setServiceCode(serviceCode);
        setMethodCode(methodCode);
        setStatusCode(statusCode);
        setData(data);
    }

    public Result(String serviceCode, String methodCode, int statusCode) {
        this(serviceCode, methodCode, statusCode, null);
    }

    public Result(String serviceCode, String methodCode, T data) {
        this(serviceCode, methodCode, StatusCode.SUCCESS, data);
    }

    public Result(String serviceCode, String methodCode) {
        this(serviceCode, methodCode, StatusCode.SUCCESS, null);
    }

    public Result(T data) {
        this("common", "return", StatusCode.SUCCESS, data);
    }

    public Result() {
        this("common", "return", StatusCode.SUCCESS, null);
    }

    public Result(int statusCode) {
        this("common", "return", statusCode, null);
    }

    public Result(int statusCode, String message) {
        this.setStatusCode(statusCode);
        this.setMessage(message);
    }

    public Result(int statusCode, String message, T data) {
        this.setStatusCode(statusCode);
        this.setMessage(message);
        this.setData(data);
    }

    public Result(String message) {
        this(StatusCode.SUCCESS, message);
    }

    public Result(int statusCode, T data) {
        this("common", "return", statusCode, data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return getStatusCode() == StatusCode.SUCCESS;
    }

    public boolean hasData() {
        return getData() != null;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
