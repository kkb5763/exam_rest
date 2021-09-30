package membership.controller;
        import org.springframework.http.HttpRequest;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.bind.annotation.RestControllerAdvice;

        import javax.servlet.http.HttpServletRequest;
        import java.util.HashMap;


@RestControllerAdvice(annotations = RestController.class)
public class MembershipControllerAdvice {
    @ExceptionHandler
    public HashMap<String,Object> errorHandler(Exception e) {
        HashMap<String,Object> hm = new HashMap<>();
        hm.put("success", "false");
        hm.put("responce","null");
        hm.put("errorMsg",e.getMessage());
        hm.put("errorCode", "000");
        System.out.println("###errer desc###");

        System.out.println(e.getMessage());
        System.out.println(e.toString());
        return hm;
    }
}
