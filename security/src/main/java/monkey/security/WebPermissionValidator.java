package monkey.security;

//权限验证器
public interface WebPermissionValidator {

    //检查：根据请求（内容）检查权限，若已获授权则返回true，未获授权则返回false。
    boolean check(WebRequest request, Long accountId);
}
